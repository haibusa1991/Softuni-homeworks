function solution(matrix) {
    let mainSum = 0;
    let secSum = 0;

    for (let i = 0; i < matrix.length; i++) {
        mainSum += matrix[i][i];

        let k = matrix.length - 1 - i;
        secSum += matrix[i][k];
    }

    return mainSum + " " + secSum;
}

console.log(solution([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
));

console.log(solution([[20, 40],
    [10, 60]]
));