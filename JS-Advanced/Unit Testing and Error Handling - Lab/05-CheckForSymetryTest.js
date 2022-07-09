const {expect} = require('chai');
const {isSymmetric} = require('./05-CheckForSymetry')

describe('Check for symmetry', () => {
    it('should return false on non array input - string', function () {
        expect(isSymmetric('not an array')).to.be.false;
    });

    it('should return false on non array input - number', function () {
        expect(isSymmetric(134)).to.be.false;
    });
    it('should return false on non array input - object', function () {
        expect(isSymmetric({not: 'an array'})).to.be.false;
    });
    it('should return false on non array input - boolean', function () {
        expect(isSymmetric(false)).to.be.false;
    });

    it('should return false on type mismatched array ', function () {
        expect(isSymmetric([1,2,3,'2',1])).to.be.false;
    });

    it('should return true for empty array', function () {
        expect(isSymmetric([])).to.be.true;
    });

    it('should return true on symmetric odd-number array', function () {
        expect(isSymmetric([1, 2, 3, 2, 1])).to.be.true;
    });

    it('should return true on symmetric even-number array', function () {
        expect(isSymmetric([1, 2, 2, 1])).to.be.true;
    });


    it('should return true on symmetric odd-number string array', function () {
        expect(isSymmetric(['1', '2', '3', '2', '1'])).to.be.true;
    });

    it('should return true on symmetric even-number string array', function () {
        expect(isSymmetric(['1', '2', '2', '1'])).to.be.true;
    });


    it('should return false on asymmetric odd-number array', function () {
        expect(isSymmetric([1, 2, 3, 4, 3])).to.be.false;
    });

    it('should return false on asymmetric even-number array', function () {
        expect(isSymmetric([1, 2, 3, 2])).to.be.false;
    });

    it('should return true on symmetric single value array', function () {
        expect(isSymmetric([1])).to.be.true;
    });
})