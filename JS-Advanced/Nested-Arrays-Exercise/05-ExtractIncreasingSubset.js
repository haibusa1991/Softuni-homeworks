function solution(arr) {
    let acc = [];
    acc.push(arr[0]);
    arr.reduce((e1, e2) => {
        if (e2 >= acc[acc.length - 1]) {
            acc.push(e2);
        }
        return acc;
    });
    return acc;
}