function extractText() {
    let list = document.getElementById('items').children;
    document.getElementById('result').value = Array.from(list).map(e => e.textContent).join('\n');
}