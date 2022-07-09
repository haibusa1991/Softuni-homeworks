function toStringExtension() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }

        toString(){
            let props = Object.getOwnPropertyNames(this);
            let result = [];
            for (let p of props) {
                result.push(`${p}: ${this[p]}`)
            }
            return `${this.constructor.name} (${result.join(', ')})`;
        }
    }

    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email)
            this.subject = subject;
        }
    }

    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }
    }

    return {
        Person,
        Teacher,
        Student
    }
}