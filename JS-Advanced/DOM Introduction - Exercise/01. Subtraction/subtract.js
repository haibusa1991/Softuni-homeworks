function subtract() {
    let n1 = Number(document.getElementById('firstNumber').value);
    let n2 = Number(document.getElementById('secondNumber').value);
    document.getElementById('result').textContent = '' + (n1 - n2);
}