function solution(arr = []) {
    let result = [];

    for (let i = 0; i < arr.length; i++) {
        if (i % 2 !== 0) {
            result.push(arr[i]);
        }
    }

    result = result.map(e => e * 2).reverse();

    return result.join(" ");
}