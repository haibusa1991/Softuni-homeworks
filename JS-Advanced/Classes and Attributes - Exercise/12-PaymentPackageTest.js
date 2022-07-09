const {PaymentPackage} = require('./12-PaymentPackage');
const {expect} = require('chai');

describe('Payment package', () => {
    describe('constructor', () => {
        it('instantiates object with string name and number value', function () {
            let o = new PaymentPackage('valid', 1);
            expect(new PaymentPackage('name', 1)).not.to.throw;

            expect(o.name).to.equal('valid');
            expect(o.value).to.equal(1);
            expect(o.VAT).to.equal(20);
            expect(o.active).to.be.true;
        });

        it('throws error on invalid parameters', function () {
            expect(() => new PaymentPackage('', 1)).to.throw(Error, 'Name must be a non-empty string');
            expect(() => new PaymentPackage([], 1)).to.throw(Error, 'Name must be a non-empty string');
            expect(() => new PaymentPackage(1, 1)).to.throw(Error, 'Name must be a non-empty string');
            expect(() => new PaymentPackage('valid', -1)).to.throw(Error, 'Value must be a non-negative number');
            expect(() => new PaymentPackage('valid', '')).to.throw(Error, 'Value must be a non-negative number');
            expect(() => new PaymentPackage('valid', [])).to.throw(Error, 'Value must be a non-negative number');
            expect(() => new PaymentPackage('valid', [])).to.throw(Error, 'Value must be a non-negative number');
        });
    })

    describe('value', () => {
        it('changes value correctly', function () {
            let o = new PaymentPackage('valid', 1);
            let val = 10;
            o.value = val;
            expect(o.value).to.equal(val);
        });

        it('works with 0', function () {
            let o = new PaymentPackage('valid', 1);
            let val = 0;
            o.value = val;
            expect(o.value).to.equal(val);
        });

        it('throws error on invalid parameters', function () {
            let o = new PaymentPackage('valid', 1);
            expect(() => o.value = '').to.throw;

            o = new PaymentPackage('valid', 1);
            expect(() => o.value = null).to.throw;

            o = new PaymentPackage('valid', 1);
            expect(() => o.value = -1).to.throw;
        })
    })

    describe('VAT', () => {
        it('changes value correctly', function () {
            let o = new PaymentPackage('valid', 1);
            let val = 10;
            o.VAT = val;
            expect(o.VAT).to.equal(val);
        });

        it('returns correct value on initialization', function () {
            let o = new PaymentPackage('valid', 1);
            expect(o.VAT).to.equal(20);
        });

        it('throws error on invalid parameters', function () {
            let o = new PaymentPackage('valid', 1);
            expect(() => o.VAT = '').to.throw(Error, 'VAT must be a non-negative number');

            o = new PaymentPackage('valid', 1);
            expect(() => o.VAT = null).to.throw(Error, 'VAT must be a non-negative number');

            o = new PaymentPackage('valid', 1);
            expect(() => o.VAT = -1).to.throw(Error, 'VAT must be a non-negative number');
        })
    })


    describe('active', () => {
        it('changes value correctly', function () {
            let o = new PaymentPackage('valid', 1);
            expect(o.active).to.be.true;

            o.active = false;
            expect(o.active).to.be.false;

            o.active = true;
            expect(o.active).to.be.true;
        });

        it('throws error on invalid parameters', function () {
            let o = new PaymentPackage('valid', 1);
            expect(() => o.active = '').to.throw(Error, 'Active status must be a boolean');
            expect(() => o.active = null).to.throw(Error, 'Active status must be a boolean');
            expect(() => o.active = 10).to.throw(Error, 'Active status must be a boolean');
        })
    })

    describe('toString', () => {
        it('active package', function () {
            let o = new PaymentPackage('Valid package', 100);
            o.VAT = 20;
            o.active = true;

            let exp = `Package: Valid package\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120`;

            expect(o.toString()).to.equal(exp);
        });

        it('inactive package', function () {
            let o = new PaymentPackage('Valid package', 100);
            o.VAT = 20;
            o.active = false;

            let exp = `Package: Valid package (inactive)\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120`;

            expect(o.toString()).to.equal(exp);
        });
    });
});
