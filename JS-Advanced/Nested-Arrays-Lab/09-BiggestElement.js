function solution(matrix = []) {
    let result = [];
    for (const arr of matrix) {
        result.push(Math.max(...arr))
    }
    return Math.max(...result);
}