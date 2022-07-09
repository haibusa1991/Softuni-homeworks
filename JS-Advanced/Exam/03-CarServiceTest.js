const {carService} = require('./03-CarService');
const {expect} = require('chai');

describe("Tests …", function () {
    describe("isItExpensive", function () {
        it("returns expensive repair on engine or transmission", function () {
            expect(carService.isItExpensive('Engine')).to.equal(`The issue with the car is more severe and it will cost more money`);
            expect(carService.isItExpensive('Transmission')).to.equal(`The issue with the car is more severe and it will cost more money`);
        });
        it("returns cheap repair on everything that's not engine or transmission", function () {
            expect(carService.isItExpensive('Brakes')).to.equal(`The overall price will be a bit cheaper`);
            expect(carService.isItExpensive('Window')).to.equal(`The overall price will be a bit cheaper`);
            expect(carService.isItExpensive('')).to.equal(`The overall price will be a bit cheaper`);
        });
    });

    describe("discount", function () {
        it("returns correct sum on valid inputs", function () {
            expect(carService.discount(0, 100)).to.equal('You cannot apply a discount');
            expect(carService.discount(3, 100)).to.equal(`Discount applied! You saved 15$`);
            expect(carService.discount(8, 100)).to.equal(`Discount applied! You saved 30$`);
            expect(carService.discount(15, 100)).to.equal(`Discount applied! You saved 30$`);
        });

        it("throw error on non-number inputs", function () {
            expect(() => carService.discount(0, '100')).to.throw(Error, "Invalid input");
            expect(() => carService.discount('0', 100)).to.throw(Error, "Invalid input");
            expect(() => carService.discount('0', '100')).to.throw(Error, "Invalid input");
        });
    });

    describe('partsToBuy', () => {
        let happyPathCatalog =  ([{ part: "part1", price: 50 }, { part: "part2", price: 100 }, { part: "part3", price: 80 }])
        let happyPathNeededParts = ['part1', 'part2'];

        it('returns correct sum on valid input', function () {
            expect(carService.partsToBuy(happyPathCatalog, happyPathNeededParts)).to.equal(150);
            expect(carService.partsToBuy(happyPathCatalog, ['partNotInStock'])).to.equal(0);
            expect(carService.partsToBuy(happyPathCatalog, ['part1', 'partNotInStock'])).to.equal(50);
            expect(carService.partsToBuy([], happyPathNeededParts)).to.equal(0);
        });

        it("throw error on non-array inputs", function () {
            expect(() => carService.partsToBuy('invalidCatalog', happyPathNeededParts)).to.throw(Error, "Invalid input");
            expect(() => carService.partsToBuy(happyPathCatalog, 'invalid parts')).to.throw(Error, "Invalid input");
            expect(() => carService.partsToBuy('invalidCatalog', 'invalid parts')).to.throw(Error, "Invalid input");
        });
    })
})
