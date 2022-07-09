const {StringBuilder} = require('./13-StringBuilder');
const {expect} = require('chai')

describe('StringBuilder', () => {
    describe('constructor', () => {
        it('initializes correctly', function () {
            expect(new StringBuilder()).to.not.throw;
            expect(new StringBuilder('init')).to.not.throw;
        });

        it('initial state', () => {
            let o = new StringBuilder();
            expect(o._stringArray.length).to.equal(0);
            o = new StringBuilder('init');
            expect(o._stringArray.join('')).to.equal('init');
        })

        it('throws error on invalid input', () => {
            expect(() => new StringBuilder(null)).to.throw(TypeError, 'Argument must be a string');
            expect(() => new StringBuilder(1)).to.throw(TypeError, 'Argument must be a string');
            expect(() => new StringBuilder([])).to.throw(TypeError, 'Argument must be a string');

        })
    });

    describe('append', () => {

        it('adds string to the end of the storage', function () {
            let o = new StringBuilder('middle')
            o.append('append');
            expect(o._stringArray.join('')).to.equal('middleappend')
            o = new StringBuilder();
            o.append('append');
            expect(o._stringArray.join('')).to.equal('append')
        });

        it('throws error on invalid input', function () {
            let o = new StringBuilder('middle')
            expect(() => o.append(null)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.append(1)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.append([])).to.throw(TypeError, 'Argument must be a string');
        });

    });

    describe('prepend', () => {

        it('adds string to the beginning of the storage', function () {
            let o = new StringBuilder('middle')
            o.prepend('prepend');
            expect(o._stringArray.join('')).to.equal('prependmiddle')

            o = new StringBuilder();
            o.prepend('prepend');
            expect(o._stringArray.join('')).to.equal('prepend')
        });

        it('throws error on invalid input', function () {
            let o = new StringBuilder('middle')
            expect(() => o.prepend(null)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.prepend(1)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.prepend([])).to.throw(TypeError, 'Argument must be a string');
        });
    });

    describe('insertAt', () => {
        let o;
        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', 0)
            expect(o._stringArray.join('')).to.equal('xyzabcdefg')
        });

        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', 3)
            expect(o._stringArray.join('')).to.equal('abcxyzdefg')
        });

        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', 7)
            expect(o._stringArray.join('')).to.equal('abcdefgxyz')
        });

        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', 13)
            expect(o._stringArray.join('')).to.equal('abcdefgxyz')
        });

        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', -1)
            expect(o._stringArray.join('')).to.equal('abcdefxyzg')
        });

        it('adds string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.insertAt('xyz', -15)
            expect(o._stringArray.join('')).to.equal('xyzabcdefg')
        });

        it('throws error on invalid input', function () {
            expect(() => o.insertAt(null)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.insertAt(1)).to.throw(TypeError, 'Argument must be a string');
            expect(() => o.insertAt([])).to.throw(TypeError, 'Argument must be a string');
        });
    });


    describe('remove', () => {
        let o;
        it('removes string to the specified index of the storage', function () {
            o = new StringBuilder('abcdefg')
            o.remove(0, 2)
            expect(o._stringArray.join('')).to.equal('cdefg')

            o.remove(4, 1)
            expect(o._stringArray.join('')).to.equal('cdef')

            o.remove(4, 1)
            expect(o._stringArray.join('')).to.equal('cdef')

            o.remove(-1, 1)
            expect(o._stringArray.join('')).to.equal('cde')

            o.remove(10, 1)
            expect(o._stringArray.join('')).to.equal('cde')
        });
    });

    describe('toString', () => {
        it('initializes correctly', function () {
            let exp = 'hello world'
            let o = new StringBuilder(exp);
            expect(o.toString()).to.equal(exp);
        });

        it('returns correct result after operations', () => {
            let o = new StringBuilder();
            o.append('abcd'); //abcd
            o.prepend('xyz'); //xyzabcd
            o.insertAt('AAA',2); //xyzAAAabcd
            o.remove(5,2) //xyAAAbcd
            expect(o.toString()).to.equal('xyAAAbcd');
        });
    });
});