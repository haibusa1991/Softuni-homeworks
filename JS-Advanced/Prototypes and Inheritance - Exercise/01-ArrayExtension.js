(function solve() {
    function last() {
        return this[this.length - 1];
    }

    function skip(numbersToSkip) {
        if (numbersToSkip >= this.length || numbersToSkip < 0) {


            return [];
        }

        return this.slice(numbersToSkip);
    }

    function take(numbers) {
        if (numbers < 0) {
            return [];
        }

        if (numbers >= this.length) {
            return this.slice(0);
        }

        return this.slice(0, numbers);
    }

    function sum() {
        if (this.length === 0) return 0;
        return this.reduce((e1, e2) => e1 + e2);
    }

    function average() {
        if (this.length === 0) return 0;
        return this.reduce((e1, e2) => e1 + e2)/this.length;
    }

    Array.prototype.last = last;
    Array.prototype.skip = skip;
    Array.prototype.take = take;
    Array.prototype.sum = sum;
    Array.prototype.average = average;
})()