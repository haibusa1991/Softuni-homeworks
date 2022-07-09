function solution(input) {
    let products = [];

    for (let town of input) {
        let [city, productName, price] = town.split('|');
        city = city.trim();
        productName = productName.trim();
        price = +price;

        if (products.filter(e => e.productName === productName).length === 0) {
            products.push({productName, price, city});
        }

        let currentProduct = {};
        for (let p of products) {
            if (p.productName === productName) {
                currentProduct = p;
                break;
            }
        }

        if (currentProduct.price > price) {
            currentProduct.price = price;
            currentProduct.city = city;
        }
    }

    for (let p of products) {
        console.log(`${p.productName} -> ${p.price} (${p.city})`)
    }
}

solution([
    'Sofia | Orange | 3',
    'Varna | Orange | 2.99',
    'Varna | Peach | 3',
    'Varna | Peach | 2.99',
    ]
)