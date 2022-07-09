function solution(arr, iter){
    for (let i = 0; i < iter; i++) {
        arr.unshift(arr.pop());
    }
    return arr.join(' ');
}