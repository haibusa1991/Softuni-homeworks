class Box<T> {
    private repo: T[];

    constructor() {
        this.repo = [];
    }

    add(val: T) {
        this.repo.push(val);
    }

    get count() {
        return this.repo.length;
    }

    remove() {
        this.repo.pop();
    }
}

let box = new Box<Number>();
box.add(1);
box.add(2);
box.add(3);
console.log(box.count);


// let box = new Box<String>();
// box.add("Pesho");
// box.add("Gosho");
// console.log(box.count);
// box.remove();
// console.log(box.count);
