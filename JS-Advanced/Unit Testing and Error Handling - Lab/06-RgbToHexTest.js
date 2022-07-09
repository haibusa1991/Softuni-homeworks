const {expect} = require('chai');
const {rgbToHexColor} = require('./06-RgbToHex');

describe('RGB to hex', () => {
        it('should return #000000 for 0,0,0', function () {
            expect(rgbToHexColor(0, 0, 0)).to.equal('#000000')
        });

        it('should return #FFFFFF for 255,255,255', function () {
            expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF')
        });

        it('should return #0F0F0F for 15,15,15', function () {
            expect(rgbToHexColor(15, 15, 15)).to.equal('#0F0F0F')
        });

        it('should return #F0F0F0 for 240,240,240', function () {
            expect(rgbToHexColor(240, 240, 240)).to.equal('#F0F0F0')
        });

        it('should return #FF0000 for 255,0,0', function () {
            expect(rgbToHexColor(255, 0, 0)).to.equal('#FF0000')
        });

        it('should return #00FF00 for 0,255,0', function () {
            expect(rgbToHexColor(0, 255, 0)).to.equal('#00FF00')
        });

        it('should return #0000FF for 0,0,255', function () {
            expect(rgbToHexColor(0, 0, 255)).to.equal('#0000FF')
        });

        it('returns string when converting', function () {
            expect(typeof rgbToHexColor(128, 150, 30)).to.equal('string')
        });

        it('returns undefined when 1 parameter is missing', function () {
            expect(rgbToHexColor(0, 0,)).to.be.undefined;
        });

        it('returns undefined when 2 parameters are  missing', function () {
            expect(rgbToHexColor(0,)).to.be.undefined;
        });

        it('returns undefined when 1 parameter is negative', function () {
            expect(rgbToHexColor(0, 0, -1)).to.be.undefined;
        });

        it('returns undefined when 2 parameters are negative', function () {
            expect(rgbToHexColor(0, -1, -1)).to.be.undefined;
        });

        it('returns undefined when 3 parameters are negative', function () {
            expect(rgbToHexColor(-1, -1, -1)).to.be.undefined;
        });

        it('returns undefined when 1 parameter is over 255', function () {
            expect(rgbToHexColor(0, 0, 256)).to.be.undefined;
        });

        it('returns undefined when 2 parameters are over 255', function () {
            expect(rgbToHexColor(0, 256, 256)).to.be.undefined;
        });

        it('returns undefined when 3 parameters are over 255', function () {
            expect(rgbToHexColor(256, 256, 256)).to.be.undefined;
        });

        it('returns undefined when 1 parameter is invalid', function () {
            expect(rgbToHexColor(0, 0, '128')).to.be.undefined;
        });
        it('returns undefined when 2 parameters are invalid', function () {
            expect(rgbToHexColor(0, '0', '128')).to.be.undefined;
        });
        it('returns undefined when 3 parameters are invalid', function () {
            expect(rgbToHexColor('0', '0', '128')).to.be.undefined;
        });
    }
)