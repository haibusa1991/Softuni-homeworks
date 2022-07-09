const {lookupChar} = require('./03-CharLookup');
const {expect} = require('chai');

describe('char lookup', () => {
        it('returns correct symbol on start of string', function () {
            expect(lookupChar('Lorem ipsum dolor sit amet',0)).to.equal('L');
        });

        it('returns correct symbol on end of string', function () {
            expect(lookupChar('Lorem ipsum dolor sit amet',25)).to.equal('t');
        });

        it('returns correct symbol in middle of string', function () {
            expect(lookupChar('Lorem ipsum dolor sit amet',10)).to.equal('m');
        });

        it('returns undefined on wrong text input - number', function () {
                expect(lookupChar(3,10)).to.be.undefined;
        });

        it('returns undefined on wrong text input - object', function () {
                expect(lookupChar({},10)).to.be.undefined;
        });

        it('returns Incorrect index on negative index', function () {
                expect(lookupChar('Lorem ipsum dolor sit amet',-5)).to.equal('Incorrect index');
        });

        it('returns Incorrect index on index > string length', function () {
                expect(lookupChar('Lorem ipsum dolor sit amet',1000)).to.equal('Incorrect index');
        });

        it('returns undefined on floating point index', function () {
                expect(lookupChar('Lorem ipsum dolor sit amet',3.5)).to.be.undefined
        });
    }
)