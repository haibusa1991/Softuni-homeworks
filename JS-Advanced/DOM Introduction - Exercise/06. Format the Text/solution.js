function solve() {
    let sentences = document.getElementById('input')
        .value
        .split('.')
        .filter(e => e.length > 0)
        .map(e => e + '.');

    if (sentences.length <= 3) {
        appendParagraph(sentences.join(''));
    } else {
        while (sentences.length > 0) {
            let currentParagraph = [];
            for (let i = 0; i < 3; i++) {
                currentParagraph.push(sentences.shift());
            }
            appendParagraph(currentParagraph.filter(e => e !== undefined).join(''));
        }
    }

    function wrapParagraph(text) {
        return `<p>${text}</p>`
    }

    function appendParagraph(text) {
        document.getElementById('output')
            .insertAdjacentHTML('beforeend', wrapParagraph(text));
    }
}