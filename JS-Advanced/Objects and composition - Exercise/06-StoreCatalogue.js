function solution(input) {
    let catalogue = [];

    for (let p of input) {
        let [name, price] = p.split(' : ');
        price = +price;
        catalogue.push({name, price});
    }

    catalogue.sort((e1, e2) => e1.name.localeCompare(e2.name));

    let categoryLetter = '';
    for (let p of catalogue) {
        if (categoryLetter !== p.name.charAt(0)) {
            categoryLetter = p.name.charAt(0);
            console.log(categoryLetter);
        }
        console.log(`  ${p.name}: ${p.price}`)
    }
}

solution(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
)

solution(['Banana : 2',
        'Rubic\'s Cube : 5',
        'Raspberry P : 4999',
        'Rolex : 100000',
        'Rollon : 10',
        'Rali Car : 2000000',
        'Pesho : 0.000001',
        'Barrel : 10'
    ]
)