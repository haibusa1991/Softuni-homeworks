function extract(content) {
    let text = document.getElementById(content).textContent;
    let matches = text.matchAll(new RegExp('\\((.+?)\\)', 'g'));

    let result = [];
    for (let m of matches) {
        result.push(m[1]);
    }

    return result.join('; ');
}
