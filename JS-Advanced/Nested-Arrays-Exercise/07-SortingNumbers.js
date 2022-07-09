function solution(arr) {
    arr.sort((e1,e2)=>e1-e2);
    let result = [];
    while (arr.length > 0) {
        result.push(arr.shift());
        if (arr.length > 0) {
            result.push(arr.pop());
        }
    }
    return result;
}