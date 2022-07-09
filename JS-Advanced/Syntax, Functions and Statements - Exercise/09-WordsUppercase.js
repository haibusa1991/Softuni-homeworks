function solution(input) {
    let words = Array.from(input.matchAll('[A-Za-z0-9]+'));
    console.log(words.join(", ").toUpperCase());
}

solution('Hi, how are you?');
solution('hello');