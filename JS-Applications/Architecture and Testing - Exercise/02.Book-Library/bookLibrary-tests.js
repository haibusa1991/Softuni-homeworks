const {chromium} = require('playwright-chromium');
const {expect} = require('chai')

let browser, page;

describe('book library tests', function () {
    this.timeout(6000);
    before(async () => browser = await chromium.launch({headless: false , slowMo: 600}));
    after(async () => await browser.close());

    beforeEach(async () => page = await browser.newPage());
    afterEach(async () => page.close());

    it('loads books correctly', async () => {
        await page.goto('http://127.0.0.1:8080/')
        await page.click('#loadBooks');
        let table = await page.textContent('tbody');
        expect(table).to.contains('Harry Potter');
        expect(table).to.contains('C#');
    });

    it('Alerts on empty fields when adding a book', async () => {
        await page.goto('http://127.0.0.1:8080/')
        let titleField = '#createForm > input[name=title]'
        let authorField = '#createForm > input[name=author]'
        let addButton = '#createForm > button'
        await page.fill(titleField, '');
        await page.fill(authorField, '');
        await page.click(addButton);
        page.on('dialog', async dialog => {
            expect(dialog.type).to.equal('alert');
            await dialog.dismiss();
        })
    })

    it('Alerts on empty author field when adding a book', async () => {
        await page.goto('http://127.0.0.1:8080/')
        let titleField = '#createForm > input[name=title]'
        let authorField = '#createForm > input[name=author]'
        let addButton = '#createForm > button'
        await page.fill(titleField, 'testTitle');
        await page.fill(authorField, '');
        await page.click(addButton);
        page.on('dialog', async dialog => {
            expect(dialog.type).to.equal('alert');
            await dialog.dismiss();
        })
    })

    it('Alerts on empty title field when adding a book', async () => {
        await page.goto('http://127.0.0.1:8080/')
        let titleField = '#createForm > input[name=title]'
        let authorField = '#createForm > input[name=author]'
        let addButton = '#createForm > button'
        await page.fill(titleField, '');
        await page.fill(authorField, 'testAuthor');
        await page.click(addButton);
        page.on('dialog', async dialog => {
            expect(dialog.type).to.equal('alert');
            await dialog.dismiss();
        })
    })
})