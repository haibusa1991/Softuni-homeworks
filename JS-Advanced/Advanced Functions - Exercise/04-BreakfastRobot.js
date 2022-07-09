function solution() {
    let repo = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    let recipes = {
        apple: {
            carbohydrate: 1,
            flavour: 2
        },

        lemonade: {
            carbohydrate: 10,
            flavour: 20
        },

        burger: {
            carbohydrate: 5,
            fat: 7,
            flavour: 3
        },

        eggs: {
            protein: 5,
            fat: 1,
            flavour: 1
        },

        turkey: {
            protein: 10,
            carbohydrate: 10,
            fat: 10,
            flavour: 10
        }
    }


    function restock(element, amount) {
        repo[element] += amount;
        return 'Success';
    }

    function prepare(order, quantity) {
        let requiredNutrients = Object.entries(recipes[order])
            .map(e => [e[0], e[1] *= quantity])

        for (let nutrient of requiredNutrients) {
            if (repo[nutrient[0]] < nutrient[1]) {
                return `Error: not enough ${nutrient[0]} in stock`
            }
        }

        for (let nutrient of requiredNutrients) {
            repo[nutrient[0]] -= nutrient[1]
        }

        return 'Success'
    }

    function report() {
        return `protein=${repo.protein} carbohydrate=${repo.carbohydrate} fat=${repo.fat} flavour=${repo.flavour}`;
    }

    function service(input) {
        let tokens = input.split(' ');

        let commands = {
            restock: (e1, e2) => restock(e1, e2),
            prepare: (e1, e2) => prepare(e1, e2),
            report: () => report()
        }

        return commands[tokens[0]](tokens[1], +tokens[2]);
    }

    return service;
}

// let manager = solution();

// console.log(manager("restock flavour 50")); // Success
// console.log(manager("prepare lemonade 4"));

// console.log(manager('restock flavour 50'));
// console.log(manager('prepare lemonade 4'));
// console.log(manager('restock carbohydrate 10'));
// console.log(manager('restock flavour 10'));
// console.log(manager('prepare apple 1'));
// console.log(manager('restock fat 10'));
// console.log(manager('prepare burger 1'));
// console.log(manager('report'));

// console.log(manager('prepare turkey 1'));
// console.log(manager('restock protein 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock carbohydrate 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock fat 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock flavour 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('report'));

