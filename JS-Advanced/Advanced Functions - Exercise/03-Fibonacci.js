function getFibonator() {
    let prevPrev = 0;
    let prev = 0;

    function fib() {
        let current = prevPrev + prev;
        if (prev === 0) {
            current = 1;
        }
        prevPrev = prev;
        prev = current;
        return current;
    }

    return fib;
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
