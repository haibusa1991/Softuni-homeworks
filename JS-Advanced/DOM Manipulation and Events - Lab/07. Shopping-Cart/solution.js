function solve() {
    let addButtons = Array.from(document.getElementsByClassName('add-product'));
    for (let button of addButtons) {
        button.addEventListener('click', addProduct);
    }

    let buttons = [];
    buttons.push(...addButtons);

    let checkoutButton = Array.from(document.getElementsByClassName('checkout'))[0];
    checkoutButton.addEventListener('click', checkout);
    buttons.push(checkoutButton);

    let outputBox = document.querySelector('textarea');

    let products = {};

    function addProduct(event) {
        let productRoot = event.target.parentElement.parentElement;
        let productName = productRoot.getElementsByClassName('product-title')[0].textContent;
        let productPrice = productRoot.getElementsByClassName('product-line-price')[0].textContent;

        outputBox.textContent = outputBox.textContent + `Added ${productName} for ${productPrice} to the cart.\n`;
        if (!products.hasOwnProperty(productName)) {
            products[productName] = 0;
        }
        products[productName] += Number(productPrice);
    }

    function checkout() {
        let productsList = Object.keys(products).join(', ');
        let totalPrice = Object.values(products).reduce((e1, e2) => e1 + e2, 0).toFixed(2);
        outputBox.textContent = outputBox.textContent + `You bought ${productsList} for ${totalPrice}.`
        buttons.map(e => e.disabled = true);
    }
}