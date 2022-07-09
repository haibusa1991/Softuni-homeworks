function solution() {
    let state = '';

    function append(string) {
        state += string;
    }

    function removeStart(numChars) {
        state = state.slice(numChars);
    }

    function removeEnd(numChars) {
        state = state.slice(0, -numChars);
    }

    function print() {
        console.log(state);
    }

    return {
        append,
        removeStart,
        removeEnd,
        print
    };
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();

let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();
