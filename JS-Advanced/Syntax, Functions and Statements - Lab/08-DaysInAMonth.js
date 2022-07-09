function solution(month, year) {
    return new Date(year, month, 0).getDate();
}

console.log(solution(2, 2021));
console.log(solution(1, 2012));