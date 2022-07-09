function solve() {
    class Figure {
        units = 'cm';

        get area() {

        }

        changeUnits(value) {
            this.units = value;
        }

        convertToMm(value) {
            let multipliers = {
                mm: 1,
                cm: 10,
                m: 1000
            }
            return value * multipliers[this.units];
        }

        convertFromMm(value) {
            let multipliers = {
                mm: 1,
                cm: 0.1,
                m: 0.001
            }

            return value * multipliers[this.units];
        }

        toString() {
            return `Figures units: ${this.units}`;
        }
    }

    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = radius;
        }

        set radius(value) {
            this._radius = this.convertToMm(value);
        }

        get radius() {
            return this.convertFromMm(this._radius);
        }

        get area() {
            return this.radius ** 2 * Math.PI;
        }

        toString() {
            return `${super.toString()} Area: ${this.area} - radius: ${this.radius}`
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super();
            this.width = width;
            this.height = height;
            this.units = units;
        }

        set width(value) {
            this._width = this.convertToMm(value);
        }

        get width() {
            return this.convertFromMm(this._width);
        }

        set height(value) {
            this._height = this.convertToMm(value);
        }

        get height() {
            return this.convertFromMm(this._height);
        }

        get area() {
            return this.width * this.height;
        }

        toString() {
            return `${super.toString()} Area: ${this.area} - width: ${this.width}, height: ${this.height}`
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    }
}