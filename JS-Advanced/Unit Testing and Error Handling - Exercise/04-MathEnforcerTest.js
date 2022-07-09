const {mathEnforcer} = require('./04-MathEnforcer');
const {expect} = require('chai');

describe('math enforcer', () => {
    describe('addFive', () => {
        it('returns correct result with integer', function () {
            expect(mathEnforcer.addFive(45)).to.equal(50);
        });

        it('returns correct result with floating point', function () {
            expect(mathEnforcer.addFive(40.6)).to.be.closeTo(45.6, 0.01);
        });

        it('returns correct result with negative integer', function () {
            expect(mathEnforcer.addFive(-10)).to.equal(-5);
        });

        it('returns correct result with negative floating point', function () {
            expect(mathEnforcer.addFive(-10.3)).to.be.closeTo(-5.3, 0.01);
        });

        it('returns undefined on wrong input - string', function () {
            expect(mathEnforcer.addFive('40')).to.be.undefined;
        });

        it('returns undefined on wrong input - object', function () {
            expect(mathEnforcer.addFive({})).to.be.undefined;
        });
    })

    describe('subtractTen', () => {
        it('returns correct result with integer', function () {
            expect(mathEnforcer.subtractTen(40)).to.equal(30);
        });

        it('returns correct result with floating point', function () {
            expect(mathEnforcer.subtractTen(20.33)).to.be.closeTo(10.33, 0.01);
        });

        it('returns correct result with negative integer', function () {
            expect(mathEnforcer.subtractTen(-55)).to.equal(-65);
        });

        it('returns correct result with negative floating point', function () {
            expect(mathEnforcer.subtractTen(-10.3)).to.be.closeTo(-20.3, 0.01);
        });

        it('returns undefined on wrong input - string', function () {
            expect(mathEnforcer.subtractTen('40')).to.be.undefined;
        });

        it('returns undefined on wrong input - object', function () {
            expect(mathEnforcer.subtractTen({})).to.be.undefined;
        });
    })


    describe('sum', () => {
        it('returns correct result with integers', function () {
            expect(mathEnforcer.sum(1,5)).to.equal(6);
        });

        it('returns correct result with floating points', function () {
            expect(mathEnforcer.sum(10.5,0.3)).to.be.closeTo(10.8, 0.01);
        });

        it('returns correct result with negative integers', function () {
            expect(mathEnforcer.sum(-5,-8)).to.equal(-13);
        });

        it('returns correct result with negative floating points', function () {
            expect(mathEnforcer.sum(-5.2, -3.2)).to.be.closeTo(-8.4, 0.01);
        });

        it('returns undefined on first number wrong input - string', function () {
            expect(mathEnforcer.sum('40',5)).to.be.undefined;
        });

        it('returns undefined on second number wrong input - string', function () {
            expect(mathEnforcer.sum(5,'5')).to.be.undefined;
        });

        it('returns undefined on both numbers wrong input - string', function () {
            expect(mathEnforcer.sum('5','5')).to.be.undefined;
        });


    })

})