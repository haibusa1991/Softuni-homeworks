function solution(fruit, weightInGrams, pricePerKilo) {
    console.log(`I need $${(weightInGrams / 1000 * pricePerKilo).toFixed(2)} to buy ${(weightInGrams / 1000).toFixed(2)} kilograms ${fruit}.`);
}

solution('orange', 2500, 1.80);
solution('apple', 1563, 2.35)