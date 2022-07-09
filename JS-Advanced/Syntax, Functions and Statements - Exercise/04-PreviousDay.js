function solution(year, month, day){
    let date = new Date(year,month-1,day-1);
    return `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`;
}

console.log(solution(2016,9,30));
console.log(solution(2016,10,1));
console.log(solution(2016,3,1));