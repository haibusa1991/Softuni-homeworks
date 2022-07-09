function solution(input) {
    console.log(sum(input));
    console.log(invSum(input))
    console.log(concat(input))

    function sum(arr) {
        let result = 0;
        for (const arrElement of arr) {
            result += arrElement;
        }
        return result;
    }

    function invSum(arr) {
        let result = 0;
        for (const arrElement of arr) {
            result += 1 / arrElement;
        }
        return result;
    }

    function concat(arr) {
        let result = "";
        for (const arrElement of arr) {
            result += arrElement;
        }
        return result;
    }
}

solution([1, 2, 3]);
solution([2, 4, 8, 16]);




