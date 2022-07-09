function solution(products) {
    let obj = {};
    products.map((e1, e2) => e2 % 2 !== 1 ? obj[e1] = Number(products[e2 + 1]) : null);
    console.log(obj);
}

solution(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solution(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);