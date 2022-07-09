function solve(...args) {
    let types = {};

    for (let arg of args) {
        let argType = typeof (arg);

        console.log(`${argType}: ${arg}`)

        if (types[argType] === undefined) {
            types[argType] = 0;
        }
        types[argType]++;

    }

    Object.entries(types)
        .sort((e1,e2)=>e2[1]-e1[1])
        .forEach(e => console.log(`${e[0]} = ${e[1]}`))
}