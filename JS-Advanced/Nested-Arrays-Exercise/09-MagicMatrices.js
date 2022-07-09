function solution(matrix) {
    let columns = [];
    for (let i = 0; i < matrix[0].length; i++) {
        columns.push(matrix.map((e1,e2)=>e1[i] ))
    }

    let results = [];
    for (let i = 0; i < matrix.length; i++) {
        results.push(matrix[i].reduce((e1, e2) => e1 + e2));
        results.push(columns[i].reduce((e1, e2) => e1 + e2));
    }
    return results.every(e1 => e1 === results[0]);
}

console.log(solution([
    [4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
));

console.log(solution([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
));

console.log(solution([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]
));