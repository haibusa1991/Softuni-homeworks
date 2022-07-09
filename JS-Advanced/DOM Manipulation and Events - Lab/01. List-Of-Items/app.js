function addItem() {
    let listItem = document.createElement('li')
    let textField = document.getElementById('newItemText');

    listItem.textContent = textField.value
    document.getElementById('items').appendChild(listItem);
    textField.value = '';
}