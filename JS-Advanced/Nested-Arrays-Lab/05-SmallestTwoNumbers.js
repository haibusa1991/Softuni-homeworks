function solution(arr) {
    arr.sort((e1, e2) => e1 - e2);
    console.log(arr[0] + " " + arr[1]);
}