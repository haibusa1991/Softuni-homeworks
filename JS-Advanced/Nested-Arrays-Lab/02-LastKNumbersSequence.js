function solution(n, k) {
    let array = [1];

    for (let i = 0; i < n - 1; i++) {
        array.push((array.slice(k * -1)).reduce((e1, e2) => e1 + e2, 0));
    }

    return array;
}

solution(8, 2);