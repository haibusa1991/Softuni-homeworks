function solution(lowerBound, upperBound) {
    let result=0;
    for (let i = Number(lowerBound); i <=Number(upperBound); i++) {
        result += i;
    }
    console.log(result);
}

solution('1','5');
solution('-8','20');


