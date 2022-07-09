function deleteByEmail() {
    let input = document.querySelector('input').value;

    let rows = Array.from(document.querySelectorAll('tbody tr'));

    for (let currentRow of rows) {
        if (currentRow.children[1].textContent === input) {
            currentRow.parentNode.removeChild(currentRow);
            document.getElementById('result').textContent = 'Deleted.';
            return;
        }
    }
    document.getElementById('result').textContent = 'Not found.';
}