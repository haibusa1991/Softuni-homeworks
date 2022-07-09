class Textbox {
    constructor(selector, regex) {
        this._elements = document.querySelectorAll(selector);
        this._invalidSymbols = regex;
    }

    set value(value) {
        this._value = value;
        Array.from(this._elements).forEach(e => e.value = value);
    }

    get value() {
        return this._value;
    }

    get elements() {
        return this._elements;
    }

    isValid() {
        for (let element of this._elements) {
            if (this._invalidSymbols.test(element.value)) {
                return false;
            }
        }
        return true;
    }
}