class Company {
    constructor() {
        this.departmentsRepo = {};
    }

    addEmployee(name, salary, position, department) {
        let inputs = [name, salary, position, department];

        if (inputs.filter(e => e === '' || e === undefined || e === null).length > 0
            || salary < 0) {
            throw new Error('Invalid input!');
        }

        if (this.departmentsRepo[department] === undefined) {
            this.departmentsRepo[department] = [];
        }

        let worker = {name, salary, position, department};
        this.departmentsRepo[department].push(worker);
        return `New employee is hired. Name: ${name}. Position: ${position}`;
    }

    bestDepartment() {
        console.log()
        let averageSalaries = [];
        Object.keys(this.departmentsRepo)

            //i'm sorry about that
            .map(dptName => this.departmentsRepo[dptName] //get each department one by one
                .map(worker => worker.salary) //get the salary of each worker of this department
                .reduce((salary1, salary2) => salary1 + salary2) / //sum the salaries of all workers
                this.departmentsRepo[dptName].length) //divide by the number of workers in the department
            .forEach(avgSalary => averageSalaries.push(avgSalary)) //push the average salary of the department to the array

        let maxAvgSalary = Math.max(...averageSalaries);
        let indexOfMaxAvgSalary = averageSalaries.indexOf(maxAvgSalary);
        let bestDepartmentName = Object.keys(this.departmentsRepo)[indexOfMaxAvgSalary];
        let bestDepartment = this.departmentsRepo[bestDepartmentName];

        bestDepartment.sort((e1, e2) => {
            let res = e2.salary - e1.salary;
            if (res === 0) {
                return e1.name.localeCompare(e2.name);
            }
            return res;
        })

        let employeesData = bestDepartment.map(e => `${e.name} ${e.salary} ${e.position}`);
        return `Best Department is: ${bestDepartmentName}\nAverage salary: ${maxAvgSalary.toFixed(2)}\n` + employeesData.join('\n');
    }
}