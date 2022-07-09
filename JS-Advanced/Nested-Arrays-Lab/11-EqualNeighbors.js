function solution(matrix) {
    let pairsCount = 0;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (i + 1 < matrix.length) {
                if (matrix[i][j] === matrix[i + 1][j]) {
                    pairsCount++;
                }
            }

            if (j + 1 < matrix[i].length) {
                if (matrix[i][j] === matrix[i][j + 1]) {
                    pairsCount++;
                }
            }
        }
    }
    return pairsCount;
}

console.log(solution([
        ['test', 'yes', 'yo', 'ho'],
        ['well', 'done', 'yo', '6'],
        ['not', 'done', 'yet', '5']
    ]
));

console.log(solution([
    ['2', '3', '4', '7', '0'],
    ['4', '0', '5', '3', '4'],
    ['2', '3', '5', '4', '2'],
    ['9', '8', '7', '5', '4']]
));

console.log(solution([
        ['2', '2', '5', '7', '4'],
        ['4', '0', '5', '3', '4'],
        ['2', '5', '5', '4', '2']
    ]
));
