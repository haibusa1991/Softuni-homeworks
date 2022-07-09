function addItem() {
    let listItem = document.createElement('li')
    let textField = document.getElementById('newItemText');

    let deleteButton = document.createElement('a');
    deleteButton.setAttribute('href', '#');
    deleteButton.textContent = '[Delete]';
    deleteButton.addEventListener('click', deleteRow);

    listItem.textContent = textField.value
    listItem.appendChild(deleteButton);

    document.getElementById('items').appendChild(listItem);
    textField.value = '';

    function deleteRow(event) {
        let row = event.currentTarget.parentElement;
        let list = row.parentElement;

       list.removeChild(row);

    }
}