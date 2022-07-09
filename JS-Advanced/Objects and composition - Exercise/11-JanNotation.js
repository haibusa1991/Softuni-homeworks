function solution(input) {
    const execute = {
        '+': (a, b) => a + b,
        '-': (a, b) => b - a,
        '*': (a, b) => a * b,
        '/': (a, b) => b / a
    }

    let isOperator = (x) => {
        return (x === '+'
            || x === '-'
            || x === '*'
            || x === '/')
    }

    let containsOperator = (arr) => {
        for (let e of arr) {
            if (isOperator(e)) {
                return true;
            }
        }
        return false;
    }

    while (input.length > 1) {
        if (!containsOperator(input)) {
            console.log('Error: too many operands!')
            return;
        }

        let operator;
        let a;
        let b;
        let buffer = [];
        while (!isOperator(operator) && containsOperator(input)) {
            b !== undefined ? buffer.push(b) : null;
            b = a;
            a = operator;
            operator = input.shift();
        }

        if (b === undefined) {
            console.log('Error: not enough operands!')
            return;
        }

        input.unshift(execute[operator](a, b));

        while (buffer.length > 0) {
            input.unshift(buffer.pop());
        }
    }
    let result = input.pop();

    if (isOperator(result)) {
        console.log('Error: not enough operands!')
        return;
    }

    console.log(result);
}