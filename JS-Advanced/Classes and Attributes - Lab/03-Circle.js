class Circle {
    constructor(radius) {
        this.radius = radius;
    }

    set radius(value) {
        this._radius = value;
    }

    get radius() {
        return this._radius;
    }

    set diameter(value) {
        this.radius = value / 2;
    }

    get diameter() {
        return this.radius * 2;
    }

    get area() {
        return (this.radius ** 2 * Math.PI);
    }
}