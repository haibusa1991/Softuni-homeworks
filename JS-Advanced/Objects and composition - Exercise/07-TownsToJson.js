function solution(input) {
    let towns = [];
    for (let e of input) {
        let tokens = e.substring(1, e.length - 1).split('|');
        let town = tokens[0].trim();
        let long = Number(tokens[2].trim()).toFixed(2);
        let lat = Number(tokens[1].trim()).toFixed(2);

        towns.push({'Town': town, 'Latitude': +lat,'Longitude': +long})
    }
    towns.shift();
    return JSON.stringify(towns);
}

console.log(solution(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));

console.log(solution(['| Town | Latitude | Longitude |',
    '| Veliko Turnovo | 43.0757 | 25.6172 |',
    '| Monatevideo | 34.50 | 56.11 |']
));