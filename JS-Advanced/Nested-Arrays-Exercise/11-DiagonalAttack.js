function solution(strings) {
    let arr = [];

    for (let row of strings) {
        arr.push(row.split(" ").map(e => Number(e)));
    }

    let mainSum = 0;
    let secondarySum = 0;

    for (let i = 0; i < arr.length; i++) {
        mainSum += arr[i][i];
        secondarySum += arr[i][arr.length - 1 - i];
    }

    if (mainSum === secondarySum) {
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr.length; j++) {
                if (i === j || arr.length - 1 - j - i === 0) {
                    continue;
                }
                arr[i][j] = mainSum;
            }
        }
    }

    for (let row of arr) {
        console.log(row.join(' '));
    }
}