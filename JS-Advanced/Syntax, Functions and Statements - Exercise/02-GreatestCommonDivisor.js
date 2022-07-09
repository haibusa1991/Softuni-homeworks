function solution(a, b) {
    console.log(gcd(Math.max(a, b), Math.min(a, b)));

    function gcd(a, b) {
        if (b === 0) {
            return a;
        }
        return gcd(b, a % b)
    }
}