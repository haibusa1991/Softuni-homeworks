class Hex {
    #decimal

    constructor(decimal) {
        this.#decimal = Number(decimal);
    }

    valueOf() {
        return this.#decimal;
    }

    toString() {
        return '0x' + this.#decimal.toString(16).toUpperCase()
    }

    plus(number) {
        return new Hex(this.getDecimal(number) + this.#decimal);
    }

    minus(number) {
        return new Hex(this.#decimal - this.getDecimal(number));
    }

    parse(hex) {
        return parseInt(hex, 16);
    }

    getDecimal(value) {
        return typeof value === 'string'
            ? this.parse(value)
            : value;
    }
}