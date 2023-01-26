const {chromium} = require('playwright-chromium');
const {expect} = require('chai');

let browser, page;

describe('messenger tests',  function () {
    before(async () => browser = await chromium.launch({headless: false, slowMo: 500}));
    after(async () => await browser.close());

    beforeEach(async () => page = await browser.newPage());
    afterEach(async () => page.close());
    this.timeout(6000);

    it('loads messages', async function () {
        await page.goto('http://127.0.0.1:8080/');
        await page.click('#refresh')
        let textArea = await page.inputValue('#messages');
        expect(textArea).to.contains('Spami: Hello, are you there?');
    });

    it('sends message', async () => {
        await page.goto('http://127.0.0.1:8080/');
        await page.fill('#author', 'Pacek');
        await page.fill('#content', 'Hello there, general Kenobi!');
        await page.click('#submit')
        await page.click('#refresh')
        let textArea = await page.inputValue('#messages');
        expect(textArea).to.contains('Pacek: Hello there, general Kenobi!');
    })
})


