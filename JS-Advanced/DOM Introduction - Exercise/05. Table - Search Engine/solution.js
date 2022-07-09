function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let text = document.getElementById('searchField').value;
        document.getElementById('searchField').value = '';

        let rows = document.querySelectorAll(('table tbody tr'));
        for (let row of rows) {
            let data = row.innerText.split('\t').join('');
            row.classList.remove('select');
            if (data.includes(text)) {
                row.className = 'select';
            }
        }
    }
}