function solution(number) {
    let lastDigit = number % 10;
    let areEqual = true;
    let sum = 0;
    let digitCount = 0;

    while (number !== 0) {
        let currentDigit = number % 10;
        if (currentDigit !== lastDigit) {
            areEqual = false;
        }

        sum += currentDigit;
        digitCount++;
        number = Math.floor(number / 10);
    }

    console.log(areEqual);
    console.log(sum);
}