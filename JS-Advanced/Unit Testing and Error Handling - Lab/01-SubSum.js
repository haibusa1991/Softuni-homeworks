function subSum(array, lowerBound, upperBound) {
    if (array.constructor.name !== 'Array') {
        return NaN;
    }

    if (lowerBound < 0) lowerBound = 0

    if (upperBound > array.length - 1) upperBound = array.length - 1;

    let result = 0;
    for (let i = lowerBound; i <= upperBound; i++) {
        result += Number(array[i]);
    }

    return result

}

console.log(subSum([10, 20, 30, 40, 50, 60], 3, 300))
console.log(subSum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1))
console.log(subSum([10, 'twenty', 30, 40], 0, 2))
console.log(subSum([], 1, 2))
console.log(subSum('text', 0, 2))
