function solve() {

    let buttons = document.querySelectorAll('button');
    let generateButton = buttons[0];
    let buyButton = buttons[1];

    generateButton.addEventListener('click', onGenerate)
    buyButton.addEventListener('click', onBuy)

    let productTable = document.querySelector('tbody');

    function onGenerate() {
        let inputRows = JSON.parse(document.querySelector('textarea').value);
        for (let inputRow of inputRows) {
            let currentRow = document.createElement('tr');

            let td1 = document.createElement('td');
            let img = document.createElement('img');
            img.src = inputRow['img'];
            td1.appendChild(img);
            currentRow.appendChild(td1);

            let td2 = document.createElement('td');
            let name = document.createElement('p');
            name.textContent = inputRow['name'];
            td2.appendChild(name);
            currentRow.appendChild(td2);

            let td3 = document.createElement('td');
            let price = document.createElement('p');
            price.textContent = inputRow['price'];
            td3.appendChild(price);
            currentRow.appendChild(td3);

            let td4 = document.createElement('td');
            let decFactor = document.createElement('p');
            decFactor.textContent = inputRow['decFactor'];
            td4.appendChild(decFactor);
            currentRow.appendChild(td4);

            let td5 = document.createElement('td');
            let checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            td5.appendChild(checkbox);
            currentRow.appendChild(td5)

            productTable.appendChild(currentRow)
        }
    }

    function onBuy() {
        let selectedRows = Array.from(document.querySelectorAll('input'))
            .filter(e => e.checked === true);

        let furniture = [];
        for (let currentRow of selectedRows) {
            let tokens = currentRow.parentElement.parentElement.querySelectorAll('p');

            let name = tokens[0].textContent;
            let price = Number(tokens[1].textContent);
            let decFactor = Number(tokens[2].textContent);

            furniture.push({name, price, decFactor});
        }

        let furnitureRow = `Bought furniture: ${furniture.map(e => e.name).join(', ')}`;
        let priceRow = `Total price: ${furniture.map(e => e.price).reduce((e1, e2) => e1 + e2).toFixed(2)}`;

        // let averageDecFactorRow = `Average decoration factor: ${furniture.map(e => e.decFactor).reduce((e1, e2) => (e1 + e2) / 2)}`;
        // this works, but Judge doesn't accept it because floating point errors

        let totalDecFactor = 0;
        for (const currentFurniture of furniture) {
            totalDecFactor += currentFurniture.decFactor;
        }
        let averageDecFactor = totalDecFactor / furniture.length;
        let averageDecFactorRow = `Average decoration factor: ${averageDecFactor}`;

        document.querySelectorAll('textarea')[1].value = [furnitureRow, priceRow, averageDecFactorRow].join('\n');
    }
}