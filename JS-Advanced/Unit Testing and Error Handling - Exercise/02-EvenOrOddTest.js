const {expect} = require('chai');
const {isOddOrEven} = require('./02-EvenOrOdd');

describe('Odd or even',() => {
    it('returns undefined on invalid input - number', function () {
        expect(isOddOrEven(1)).to.be.undefined;
    });

    it('returns undefined on invalid input - boolean', function () {
        expect(isOddOrEven(true)).to.be.undefined;
    });

    it('returns undefined on invalid input - object', function () {
        expect(isOddOrEven({})).to.be.undefined;
    });

    it('returns odd on string with odd number of chars', function () {
        expect(isOddOrEven('lorem ipsum')).to.equal('odd');
    });

    it('returns odd on string with even number of chars', function () {
        expect(isOddOrEven('loremipsum')).to.equal('even');
    });

    it('returns even on multiple strings', function () {
        isOddOrEven('loremipsum11');
        isOddOrEven('loremipsum33');

        expect(isOddOrEven('loremipsum')).to.equal('even');
    });

})