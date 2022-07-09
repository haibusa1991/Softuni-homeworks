function addItem() {
    let textBox = document.getElementById('newItemText');
    let valueBox = document.getElementById('newItemValue');

    let newItem = document.createElement('option');
    newItem.value = valueBox.value;
    newItem.textContent = textBox.value;

    document.getElementById('menu').appendChild(newItem);
    textBox.value = '';
    valueBox.value = '';
}