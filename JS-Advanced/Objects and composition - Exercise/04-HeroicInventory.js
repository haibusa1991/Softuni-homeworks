function solution (heroesInput){
    let heroes = [];
    for (let hero of heroesInput) {
        let tokens = hero.split(' / ');

        let currentHero ={};
        currentHero['name'] = tokens[0];
        currentHero['level'] = +tokens[1];
        currentHero['items'] = tokens[2] ? tokens[2].split(', ') : [];
        heroes.push(currentHero)
    }
    console.log(JSON.stringify(heroes));
}