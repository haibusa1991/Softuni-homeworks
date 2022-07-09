function sumTable() {
    let prices = document.querySelectorAll('td:last-child');
    let finalSum = 0;
    for (let i = 0; i < prices.length-1; i++) {
        finalSum += Number(prices[i].textContent);
    }
    document.getElementById('sum').textContent = finalSum;
}