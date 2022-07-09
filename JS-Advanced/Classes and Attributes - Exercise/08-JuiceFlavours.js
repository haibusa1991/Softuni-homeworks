function solve(juices) {
    let juicesRepo = new Map();
    let bottlesRepo = new Set();

    for (let juice of juices) {
        let [flavour, amount] = juice.split(' => ');

        if (!juicesRepo.has(flavour)) {
            juicesRepo.set(flavour, 0);
        }

        let newJuiceAmount = juicesRepo.get(flavour) + +amount;
        juicesRepo.set(flavour, newJuiceAmount);

        if (newJuiceAmount >= 1000) {
            bottlesRepo.add(flavour);
        }
    }

    for (let flavour of bottlesRepo) {
        console.log(`${flavour} => ${Math.floor(juicesRepo.get(flavour) / 1000)}`);
    }
}