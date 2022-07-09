function solution(towns) {
    let obj = {};

    for (let town of towns) {
        let tokens = town.split(' <-> ');
        if (!obj[tokens[0]]) {
            obj[tokens[0]] = 0;
        }
        obj[tokens[0]] += Number(tokens[1]);
    }

    for (let r of Object.entries(obj)) {
        console.log(r[0] + " : " + r[1]);
    }
}


solution(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
);

solution(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
)