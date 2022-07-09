function area() {
    return Math.abs(this.x * this.y);
}

function vol() {
    return Math.abs(this.x * this.y * this.z);
}

function solve(areaIn, volIn, input) {
    let dims = JSON.parse(input);
    let res = [];

    for (let obj of dims) {
        let current = {
            area: areaIn.call(obj),
            volume: volIn.call(obj)
        };

        res.push(current);
    }
    return res;
}
