function calculator() {
    let num1;
    let num2;
    let result;

    function init(f1, f2, fr) {
        num1 = document.querySelector(f1);
        num2 = document.querySelector(f2);
        result = document.querySelector(fr);
    }

    function add() {
        result.value = Number(num1.value) + Number(num2.value);
    }

    function subtract() {
        result.value = Number(num1.value) - Number(num2.value);
    }

    return {
        init,
        add,
        subtract
    }
}

const calculate = calculator();
calculate.init('#num1', '#num2', '#result');
console.log()




