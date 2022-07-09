class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(amount) {
        this.innerLength += amount;
    }

    decrease(amount) {
        this.increase(amount * -1);
        this.innerLength < 0
            ? this.innerLength = 0
            : null;
    }

    toString() {
        let truncation = '';
        if (this.innerString.length > this.innerLength) {
            truncation = '...';
        }
        return this.innerString.slice(0, this.innerLength) + truncation;
    }
}
