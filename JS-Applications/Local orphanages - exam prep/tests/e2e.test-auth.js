const {chromium} = require('playwright-chromium');
const {expect} = require('chai');

const host = 'http://localhost:3000'; // Application host (NOT service host - that can be anything)
const interval = 500;
const DEBUG = false;
const slowMo = 1000;

const mockData = require('./mock-data.json');

const endpoints = {
    register: '/users/register',
    login: '/users/login',
    logout: '/users/logout',
    catalog: '/data/posts?sortBy=_createdOn%20desc',
    create: '/data/posts',
    donate: '/data/donations',
    details: (id) => `/data/posts/${id}`,
    delete: (id) => `/data/posts/${id}`,
    profile: (id) => `/data/posts?where=_ownerId%3D%22${id}%22&sortBy=_createdOn%20desc`,
    own: (postId, userId) =>
        `/data/donations?where=postId%3D%22${postId}%22%20and%20_ownerId%3D%22${userId}%22&count`,
    total: (postId) => `/data/donations?where=postId%3D%22${postId}%22&distinct=_ownerId&count`,
};

let browser;
let context;
let page;

describe('E2E tests', function () {
    // Setup
    this.timeout(DEBUG ? 120000 : 7000);
    before(async () => (browser = await chromium.launch(DEBUG ? {headless: false, slowMo} : {})));
    after(async () => await browser.close());
    beforeEach(async () => {
        context = await browser.newContext();
        setupContext(context);
        page = await context.newPage();
    });
    afterEach(async () => {
        await page.close();
        await context.close();
    });

    describe('Authentication [ 20 Points ]', () => {
        it('Register does NOT work with empty fields [ 2.5 Points ]', async () => {
            const {post} = await handle(endpoints.register);
            const isCalled = post().isHandled;

            await page.goto(host);
            await page.waitForTimeout(interval);
            await page.click('text=Register');

            await page.waitForTimeout(interval);
            await page.waitForSelector('form');

            await page.click('[type="submit"]');

            await page.waitForTimeout(interval);

            expect(isCalled()).to.be.false;
        });

        it('Register makes correct API call [ 5 Points ]', async () => {
            const data = mockData.users[0];
            const {post} = await handle(endpoints.register);
            const {onRequest} = post(data);

            await page.goto(host);
            await page.waitForTimeout(interval);
            await page.click('text=Register');

            await page.waitForTimeout(interval);
            await page.waitForSelector('form');

            await page.fill('[name="email"]', data.email);
            await page.fill('[name="password"]', data.password);
            await page.fill('[name="repeatPassword"]', data.password);

            const [request] = await Promise.all([onRequest(), page.click('[type="submit"]')]);

            const postData = JSON.parse(request.postData());

            expect(postData.email).to.equal(data.email);
            expect(postData.password).to.equal(data.password);
        });

        it('Login does NOT work with empty fields [ 2.5 Points ]', async () => {
            const {post} = await handle(endpoints.login);
            const isCalled = post().isHandled;

            await page.goto(host);
            await page.waitForTimeout(interval);
            await page.click('text=Login');

            await page.waitForTimeout(interval);
            await page.waitForSelector('form');

            await page.click('[type="submit"]');

            await page.waitForTimeout(interval);

            expect(isCalled()).to.be.false;
        });

        it('Login makes correct API call [ 5 Points ]', async () => {
            const data = mockData.users[0];
            const {post} = await handle(endpoints.login);
            const {onRequest} = post(data);

            await page.goto(host);
            await page.waitForTimeout(interval);
            await page.click('text=Login');

            await page.waitForTimeout(interval);
            await page.waitForSelector('form');

            await page.fill('[name="email"]', data.email);
            await page.fill('[name="password"]', data.password);

            const [request] = await Promise.all([onRequest(), page.click('[type="submit"]')]);

            const postData = JSON.parse(request.postData());
            expect(postData.email).to.equal(data.email);
            expect(postData.password).to.equal(data.password);
        });

        it('Logout makes correct API call [ 5 Points ]', async () => {
            const data = mockData.users[0];
            const {post} = await handle(endpoints.login);
            const {get} = await handle(endpoints.logout);
            const {onResponse} = post(data);
            const {onRequest} = get('', {json: false, status: 204});

            await page.goto(host);
            await page.click('text=Login');
            await page.waitForTimeout(interval);
            await page.waitForSelector('form');
            await page.fill('[name="email"]', data.email);
            await page.fill('[name="password"]', data.password);

            await Promise.all([onResponse(), page.click('[type="submit"]')]);

            await page.waitForTimeout(interval);

            const [request] = await Promise.all([onRequest(), page.click('nav >> text=Logout')]);

            const token = request.headers()['x-authorization'];
            expect(request.method()).to.equal('GET');
            expect(token).to.equal(data.accessToken);
        });
    });

    async function setupContext(context) {
        // Authentication
        await handleContext(context, endpoints.login, {post: mockData.users[0]});
        await handleContext(context, endpoints.register, {post: mockData.users[0]});
        await handleContext(context, endpoints.logout, {
            get: (h) => h('', {json: false, status: 204}),
        });

        // Catalog and Details
        await handleContext(context, endpoints.catalog, {get: mockData.catalog});
        await handleContext(context, endpoints.details('1001'), {get: mockData.catalog[0]});
        await handleContext(context, endpoints.details('1002'), {get: mockData.catalog[1]});
        await handleContext(context, endpoints.details('1003'), {get: mockData.catalog[2]});

        await handleContext(endpoints.profile('0001'), {get: mockData.catalog.slice(0, 2)}, context);

        await handleContext(endpoints.total('1001'), {get: 6}, context);
        await handleContext(endpoints.total('1002'), {get: 4}, context);
        await handleContext(endpoints.total('1003'), {get: 7}, context);

        await handleContext(endpoints.own('1001', '0001'), {get: 1}, context);
        await handleContext(endpoints.own('1002', '0001'), {get: 0}, context);
        await handleContext(endpoints.own('1003', '0001'), {get: 0}, context);

        // Block external calls
        await context.route(
            (url) => url.href.slice(0, host.length) != host,
            (route) => {
                if (DEBUG) {
                    console.log('Preventing external call to ' + route.request().url());
                }
                route.abort();
            }
        );
    }

    function handle(match, handlers) {
        return handleRaw.call(page, match, handlers);
    }

    function handleContext(context, match, handlers) {
        return handleRaw.call(context, match, handlers);
    }

    async function handleRaw(match, handlers) {
        const methodHandlers = {};
        const result = {
            get: (returns, options) => request('GET', returns, options),
            post: (returns, options) => request('POST', returns, options),
            put: (returns, options) => request('PUT', returns, options),
            patch: (returns, options) => request('PATCH', returns, options),
            del: (returns, options) => request('DELETE', returns, options),
            delete: (returns, options) => request('DELETE', returns, options),
        };

        const context = this;

        await context.route(urlPredicate, (route, request) => {
            if (DEBUG) {
                console.log('>>>', request.method(), request.url());
            }

            const handler = methodHandlers[request.method().toLowerCase()];
            if (handler == undefined) {
                route.continue();
            } else {
                handler(route, request);
            }
        });

        if (handlers) {
            for (let method in handlers) {
                if (typeof handlers[method] == 'function') {
                    handlers[method](result[method]);
                } else {
                    result[method](handlers[method]);
                }
            }
        }

        return result;

        function request(method, returns, options) {
            let handled = false;

            methodHandlers[method.toLowerCase()] = (route, request) => {
                handled = true;
                route.fulfill(respond(returns, options));
            };

            return {
                onRequest: () => context.waitForRequest(urlPredicate),
                onResponse: () => context.waitForResponse(urlPredicate),
                isHandled: () => handled,
            };
        }

        function urlPredicate(current) {
            if (current instanceof URL) {
                return current.href.toLowerCase().includes(match.toLowerCase());
            } else {
                return current.url().toLowerCase().includes(match.toLowerCase());
            }
        }
    }

    function respond(data, options = {}) {
        options = Object.assign(
            {
                json: true,
                status: 200,
            },
            options
        );

        const headers = {
            'Access-Control-Allow-Origin': '*',
        };
        if (options.json) {
            headers['Content-Type'] = 'application/json';
            data = JSON.stringify(data);
        }

        return {
            status: options.status,
            headers,
            body: data,
        };
    }
})
