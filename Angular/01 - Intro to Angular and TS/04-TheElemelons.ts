abstract class Melon {
    public weight: number;
    public _melonSort: string;

    private _element: string;
    private _index: number;

    constructor(weight: number, melonSort: string, element: string) {
        this.weight = weight;
        this._melonSort = melonSort;
        this._element = element;
        this._index = this.weight * this._melonSort.length;
    }

    set element(element) {
        this._element = element;
    }

    toString() {
        return `
Element: ${this._element}
Sort: ${this._melonSort}
Element Index: ${this._index};
        `
    }
}

class Watermelon extends Melon {
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort, 'Water');
    }
}

class Firemelon extends Melon {
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort,'Fire');
    }
}

class Earthmelon extends Melon {
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort,'Earth');
    }
}

class Airmelon extends Melon {
    constructor(weight: number, melonSort: string) {
        super(weight, melonSort,'Air');
    }
}

class Melolemonmelon extends Airmelon {
    private _elements: string[];

    constructor(weight: number, melonSort: string) {
        super(weight, melonSort);
        this._elements = [
            'Water',
            'Fire',
            'Earth',
            'Air'
        ];
        this.morph();
    }

    morph() {
        let element = this._elements.shift();
        this.element = element;
        this._elements.push(element);
    }

}

let melon1 = new Melolemonmelon(12.5, 'Kingsize')
console.log(melon1.toString());
melon1.morph();
console.log(melon1.toString());
melon1.morph();
console.log(melon1.toString());
melon1.morph();
console.log(melon1.toString());
melon1.morph();
console.log(melon1.toString());
melon1.morph();
console.log(melon1.toString());
