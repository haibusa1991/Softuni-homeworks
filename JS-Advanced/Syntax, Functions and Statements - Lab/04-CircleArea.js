function solution(radius) {
    let inputType = typeof (radius);
    if (inputType === "number") {
        console.log((radius ** 2 * Math.PI).toFixed(2));
        return;
    }
    console.log(`We can not calculate the circle area, because we receive a ${inputType}.`);
}

solution(5);
solution('name');