const {expect} = require('chai');
const {sum} = require("./04-SumOfNumbers");

describe('Sum of numbers', function () {
    it('should take array of numbers', function () {
        expect(sum('a')).to.be.NaN;
    });

    it('sum numbers', function () {
        expect(sum([1,2,3])).to.equal(6);
    });

    it('return zero on empty array', function () {
        expect(sum([])).to.equal(0);
    });
})