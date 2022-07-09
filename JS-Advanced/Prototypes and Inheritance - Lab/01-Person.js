class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get fullName() {
        return this.firstName + ' ' + this.lastName;
    }

    set fullName(names) {
        if (typeof names !== 'string') return;

        let tokens = names.split(' ');
        if (tokens.length !== 2) return;

        this.firstName = tokens[0];
        this.lastName = tokens[1];
    }
}