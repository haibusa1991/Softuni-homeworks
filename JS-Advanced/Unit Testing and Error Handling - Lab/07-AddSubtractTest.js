const {expect} = require('chai');
const {createCalculator} = require('./07-AddSubtract')

describe('Add/Subtract', () => {
    it('returns object on execution', () => {
        expect(typeof createCalculator()).to.equal('object')
    });

    it('object has add property', () => {
        expect(createCalculator().hasOwnProperty('add')).to.be.true;
    });

    it('object add property is a function', () => {
        expect(typeof createCalculator().add).to.equal('function');
    });

    it('object has subtract property', () => {
        expect(createCalculator().hasOwnProperty('subtract')).to.be.true;
    });

    it('object subtract property is a function', () => {
        expect(typeof createCalculator().subtract).to.equal('function');
    });

    it('object has get property', () => {
        expect(createCalculator().hasOwnProperty('get')).to.be.true;
    });

    it('object get property is a function', () => {
        expect(typeof createCalculator().get).to.equal('function');
    });

    it('internal sum cannot be modified from the outside', () => {
        let calc = createCalculator();
        calc.add(1000)
        calc.value = 15;
        expect(calc.get()).to.equal(1000);
    });

    it('add takes number', function () {
        let calc = createCalculator();
        calc.add(5);
        expect(calc.get()).to.equal(5);
    });

    it('add takes number as string', function () {
        let calc = createCalculator();
        calc.add('5');
        expect(calc.get()).to.equal(5);
    });

    it('add returns NaN on invalid input-string', function () {
        let calc = createCalculator();
        calc.add('az');
        expect(calc.get()).to.be.NaN;
    });

    it('subtract takes number', function () {
        let calc = createCalculator();
        calc.subtract(5);
        expect(calc.get()).to.equal(-5);
    });

    it('subtract takes number as string', function () {
        let calc = createCalculator();
        calc.subtract('5');
        expect(calc.get()).to.equal(-5);
    });

    it('add returns NaN on invalid input-string', function () {
        let calc = createCalculator();
        calc.subtract('az');
        expect(calc.get()).to.be.NaN;
    });

    it('get returns correct internal value', function () {
        let calc = createCalculator();
        calc.subtract(15);
        expect(calc.get()).to.equal(-15);
    });
})