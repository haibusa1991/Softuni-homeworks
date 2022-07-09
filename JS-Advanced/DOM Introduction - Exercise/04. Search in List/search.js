function search() {
    let searchItem = document.getElementById('searchText').value;
    let towns = Array.from(document.getElementById('towns').children);
    let matchesCount = 0;

    for (let town of towns) {
        if (town.textContent.includes(searchItem)) {
            decorate(town);
            matchesCount++;
            document.getElementById('result').textContent = `${matchesCount} matches found`;
            continue;
        }
        clearDecoration(town);
    }

    function decorate(listItem) {
        listItem.style.textDecoration = 'underline';
        listItem.style.fontWeight = 'bold';
    }

    function clearDecoration(listItem) {
        listItem.style.textDecoration = '';
        listItem.style.fontWeight = '';
    }
}
