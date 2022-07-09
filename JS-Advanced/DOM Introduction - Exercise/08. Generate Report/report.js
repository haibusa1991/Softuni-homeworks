// https://judge.softuni.org/Contests/Compete/Index/2761#7
function generateReport() {
    let selectedColumns = [];

    let columns = Array.from(document.querySelector('thead tr').children);
    for (let c of columns) {
        selectedColumns.push(c.children[0].checked);
    }

    selectedColumns = selectedColumns.map((e1, e2) => e1 === false ? -1 : e2).filter(e => e !== -1);

    let rows = Array.from(document.querySelector('tbody').children);

    let results = [];
    for (let r of rows) {
        let currentRow = {};
        for (let i of selectedColumns) {
            let val = r.children[i].textContent;
            let key = columns[i].textContent.toLowerCase().trim();
            currentRow[key] = val;
        }
        results.push(currentRow)
    }
    document.getElementById('output').value = JSON.stringify(results, null, 2);
}