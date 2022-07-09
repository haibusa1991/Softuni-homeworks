function solution(inputArr) {
    return inputArr.sort((e1, e2) => e1 - e2).slice(-Math.ceil(inputArr.length / 2));
}

console.log(solution([3, 19, 14, 7, 2, 19, 6]));
console.log(solution([4, 7, 2, 5]));