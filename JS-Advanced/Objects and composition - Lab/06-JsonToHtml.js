function fromJSONToHTMLTable(input) {
    let table = JSON.parse(input);

    let result = ['<table>'];

    result.push(generateHeader(table));

    for (let tableRow of table) {
        result.push(generateRow(tableRow));
    }

    result.push('</table>');
    return result.join('\n');

    function escape(val) {
        return val.toString()
            .replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    }

    function generateHeader(table) {
        let result = '<tr>';
        for (let columnName of Object.keys(table[0])) {
            result += `<th>${escape(columnName)}</th>`;
        }
        result += '</tr>';
        return result;
    }

    function generateRow(tableRow) {
        let result = '<tr>';
        for (let rowValue of Object.values(tableRow)) {
            result += `<td>${escape(rowValue)}</td>`;
        }
        result += '</tr>';
        return result;
    }
}