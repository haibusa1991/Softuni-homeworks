function solve(cars) {
    let carRepo = new Map();

    for (let car of cars) {
        let [make, model, count] = car.split(' | ');
        count = +count;

        if (!carRepo.has(make)) {
            carRepo.set(make, new Map());
        }

        let models = carRepo.get(make)
        if (!models.has(model)) {
            models.set(model, 0);
        }

        let currentModelCount = models.get(model) + count;
        models.set(model, currentModelCount);
        carRepo.set(make, models);
    }

    for (let [make, models] of carRepo) {
        console.log(make)
        for (let [model, count] of models) {
            console.log(`###${model} -> ${count}`)
        }
    }
}
