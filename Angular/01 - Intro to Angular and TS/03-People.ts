

abstract class Employee {
    private name: string;
    private age: number;
    private _salary: number = 0;
    public dividend: number = 0;
    private _tasks: string[];

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    collectSalary() {
        console.log(`${this.name} received ${this._salary + this.dividend} this month`);
    }

    work() {
        let task = this._tasks.shift();
        console.log(`${this.name} ${task}`)
        this._tasks.push(task);
    }


    set tasks(value: string[]) {
        this._tasks = value;
    }

}

export class Junior extends Employee {
    constructor(name: string, age: number) {
        super(name, age);
        this.tasks = ['is working on a simple task.'];
    }
}

export class Senior extends Employee {
    constructor(name: string, age: number) {
        super(name, age);
        this.tasks = [
            'is working on a complicated task.',
            'is taking time off work.',
            'is supervising junior workers.'
        ]
    }
}

export class Manager extends Employee {
    constructor(name: string, age: number) {
        super(name, age);
        this.tasks = [
            'scheduled a meeting.',
            'is preparing a quarterly report.'
        ];
    }
}
