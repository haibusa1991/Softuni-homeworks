function solve() {
    let selector = {
        'Camel Case': (t) => toCamelCase(t),
        'Pascal Case': (t) => toPascalCase(t)
    }

    let convention = document.getElementById('naming-convention').value;
    let result = document.getElementById('result');
    if (!(convention in selector)) {

        result.textContent = 'Error!';
        return;
    }

    let text = document.getElementById('text').value;
    result.textContent = selector[convention](text);

    function toPascalCase(text) {
        return text.split(' ')
            .map(e => e.trim())
            .map(e => e.toLowerCase())
            .map(e => e.charAt(0).toUpperCase() + e.substring(1))
            .join('');
    }

    function toCamelCase(text) {
        let transformed = toPascalCase(text);
        return transformed.charAt(0).toLowerCase() + transformed.substring(1);
    }
}