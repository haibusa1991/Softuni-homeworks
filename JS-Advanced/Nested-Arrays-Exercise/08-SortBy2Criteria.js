function solution(arr) {
    arr.sort((e1, e2) => {
        let result = e1.length - e2.length;
        if (result === 0) {
            return e1.toLowerCase().localeCompare(e2.toLowerCase());
        }
        return result;
    });
    console.log(arr.join('\n'))
}

solution(['alpha',
    'beta',
    'gamma']
);

solution(['Isacc',
    'Theodor',
    'Jack',
    'Harrison',
    'George']
);

solution(['test',
    'Deny',
    'omen',
    'Default']
);