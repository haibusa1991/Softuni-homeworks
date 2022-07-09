window.addEventListener("load", solve);

function solve() {
    document.getElementById('publish').addEventListener('click', onPublish);


    function onPublish(e) {
        e.preventDefault();

        let makeField = document.getElementById('make');
        let modelField = document.getElementById('model');
        let yearField = document.getElementById('year');
        let fuelField = document.getElementById('fuel');
        let originalCostField = document.getElementById('original-cost');
        let sellingPriceField = document.getElementById('selling-price');

        let fields = [makeField, modelField, yearField, fuelField, originalCostField, sellingPriceField];

        if (fields.find(e => e.value === '')
            || +originalCostField.value >= +sellingPriceField.value) {
            // console.log('empty field or prices worng')
            return;
        }

        let car = getCarForSaleElement(fields);
        let editBtn = document.createElement('button');
        editBtn.classList.add('action-btn', 'edit');
        editBtn.textContent = 'Edit';
        editBtn.addEventListener('click', onEdit);

        let sellBtn = document.createElement('button');
        sellBtn.classList.add('action-btn', 'sell');
        sellBtn.textContent = 'Sell';
        sellBtn.addEventListener('click', onSell);

        car.lastChild.appendChild(editBtn)
        car.lastChild.appendChild(sellBtn)

        document.getElementById('table-body').appendChild(car);

        fields.forEach(e => e.value = '');

        function onEdit(e) {
            e.target.parentElement.parentElement.remove();
            let nodes = Array.from(car.children);
            for (let i = 0; i < 6; i++) {
                fields[i].value = nodes[i].textContent;
            }
        }

        function onSell(e) {
            e.target.parentElement.parentElement.remove();
            let soldCar = getSoldCarElement(car)
            document.getElementById('cars-list').appendChild(soldCar);
            let profitField = document.getElementById('profit');
            let currentProfit = +profitField.textContent;
            let carProfit = +soldCar.lastChild.textContent;
            profitField.textContent = (currentProfit+carProfit).toFixed(2);
        }

    }

    function getCarForSaleElement(tokens) {
        let row = document.createElement('tr');
        row.classList.add('row');
        row.innerHTML =
            `<td>${tokens[0].value}</td>
           <td>${tokens[1].value}</td>
           <td>${tokens[2].value}</td>
           <td>${tokens[3].value}</td>
           <td>${tokens[4].value}</td>
           <td>${tokens[5].value}</td>
           <td></td>`
        return row;
    }

    function getSoldCarElement(carElement) {
        let summary = document.createElement('li');
        summary.classList.add('each-list');
        let tokens = carElement.children;

        summary.innerHTML =
            `<span>${tokens[0].textContent} ${tokens[1].textContent}</span>
            <span>${tokens[2].textContent}</span>
            <span>${+tokens[5].textContent - +tokens[4].textContent}</span>`

        return summary;
    }
}