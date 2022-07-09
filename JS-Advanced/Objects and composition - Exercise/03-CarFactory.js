function solution(requiredCar) {
    let engines = [
        {power: 90, volume: 1800},
        {power: 120, volume: 2400},
        {power: 200, volume: 3500}]

    return {
        model: requiredCar.model,
        engine: engines.filter(e => e.power >= requiredCar.power)[0],
        carriage: {type: requiredCar.carriage, color: requiredCar.color},
        wheels: requiredCar.wheelsize % 2 === 0 ?
            Array(4).fill(requiredCar.wheelsize - 1) :
            Array(4).fill(requiredCar.wheelsize)
    }
}

console.log(solution({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));

console.log(solution({
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }
));