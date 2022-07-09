function solution(input){
    let output = [];
    for (let i = 0; i < input.length; i++) {
        if (i%2===0) {
            output.push(input[i]);
        }
    }
    console.log(output.join(' '));
}

solution(['20', '30', '40', '50', '60']);
solution(['5', '10']);