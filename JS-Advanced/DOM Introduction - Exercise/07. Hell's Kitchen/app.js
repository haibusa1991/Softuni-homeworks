function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick() {
        let text = document.getElementById('inputs').children[1].value;
        let restaurant = getBestRestaurant(text);

        document.querySelector('div#outputs #bestRestaurant p').textContent = formatRestaurant(restaurant);
        document.querySelector('div#outputs #workers p').textContent = formatWorkers(restaurant);
    }

    function getBestRestaurant(text) {
        let restaurantList = [];

        let parsedData = JSON.parse(text)
        for (let restaurantData of parsedData) {

            let workersTokens = restaurantData.split(' - ')[1].split(', ');
            let currentWorkers = [];

            for (let worker of workersTokens) {
                let name = worker.split(' ')[0];
                let salary = Number(worker.split(' ')[1]);
                currentWorkers.push({name, salary})
            }

            let restaurantName = restaurantData.split(' - ')[0];
            let currentRestaurant;
            let isExisting = false;

            for (let r of restaurantList) {
                if (restaurantName === r.name) {
                    currentRestaurant = r;
                    isExisting = true;
                    break;
                }
            }

            if (currentRestaurant === undefined) {
                currentRestaurant = {
                    name: restaurantName,
                    workers: [],
                    averageSalary: () => {
                        let avg = 0;
                        for (let s of currentRestaurant.workers) {
                            avg += s.salary;
                        }
                        return avg / currentRestaurant.workers.length;
                    },
                    sortWorkers: () => {
                        currentRestaurant.workers.sort((e1, e2) => e2.salary - e1.salary);
                    }
                }
            }

            currentRestaurant.workers = currentRestaurant.workers.concat(currentWorkers)
            if (!isExisting) {
                restaurantList.push(currentRestaurant);
            }
        }

        return restaurantList.sort((e1, e2) => e2.averageSalary() - e1.averageSalary())[0];
    }

    function formatRestaurant(restaurant) {
        restaurant.sortWorkers();
        return `Name: ${restaurant.name} Average Salary: ${restaurant.averageSalary().toFixed(2)} Best Salary: ${restaurant.workers[0].salary.toFixed(2)}`;
    }

    function formatWorkers(restaurant) {
        restaurant.sortWorkers();
        let retval = [];

        for (let w of restaurant.workers) {
            retval.push(`Name: ${w.name} With Salary: ${w.salary}`);
        }

        return retval.join(' ');
    }
}