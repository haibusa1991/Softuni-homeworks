function colorize() {
    let rows = document.querySelectorAll('tr:nth-child(even)');
    for (const row of rows) {
        row.style.background = 'Teal';
    }
}