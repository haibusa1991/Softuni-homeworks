class List {
    constructor() {
        this.numbers = [];
        this.size = 0;
    }

    sortArray() {
        this.numbers.sort((e1, e2) => e1 - e2);
    }

    add(number) {
        this.numbers.push(number);
        this.sortArray();
        this.size = this.numbers.length;
    }

    remove(index) {
        let key = this.get(index);
        if (key !== undefined) {
            this.numbers.splice(index,1)
            this.size = this.numbers.length;
        }
    }

    get(index) {
        if (index >= 0 && index < this.size) {
            return this.numbers[index];
        }
    }
}
