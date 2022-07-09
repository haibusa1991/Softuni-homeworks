const {expect} = require('chai');

const {isOddOrEven} = require("./mochaSetup");

describe('even or odd', () => {
    it('is string', () => {
        expect(isOddOrEven(3)).to.undefined;
    });

    it('isOdd', () => {
        expect(isOddOrEven('s')).to.equal('odd');
    });

    it('is string', () => {
        expect(isOddOrEven('aa')).to.equal('even');
    });
})