function solve(commands) {
    let carService = service();

    for (let i = 0; i < commands.length; i++) {
        let tokens = commands[i].split(' ');

        let command = tokens[0];
        if (commands[i].includes('inherit')) {
            command = 'inherit';
        }

        switch (command) {
            case 'create':
                carService.create(tokens[1]);
                break;
            case 'inherit':
                carService.inherits(tokens[1], tokens[3]);
                break;
            case 'set':
                carService.set(tokens[1], tokens[2], tokens[3]);
                break;
            case 'print':
                carService.print(tokens[1]);
                break;
        }
    }

    function service() {
        let repo = [];

        function create(carName) {
            repo.push({name: carName});
        }

        function inherits(carName, parentName) {
            create(carName);
            let parent = getCarByName(parentName);
            let child = getCarByName(carName);
            child['parent'] = parent;
        }

        function set(carName, key, value) {
            let car = getCarByName(carName);
            car[key] = value;
        }

        function getProperties(carName, propertiesArr) {
            let car = getCarByName(carName);
            let data = Object.entries(car)
                .filter(e => typeof (e[1]) === 'string')
                .filter(e => e[0] !== 'name')
                .map(e => e.join(':'))
                .join(',');

            let arr = [];
            arr.push(data);

            if (car.parent !== undefined) {
                return getProperties(car.parent.name, arr);
            }

            return arr.concat(propertiesArr);
        }

        function print(carName) {
            let properties = getProperties(carName);
            console.log(properties
                .filter(e => e !== undefined)
                .reverse()
                .join(','));
        }

        function getCarByName(carName) {
            return repo.filter(e => e.name === carName)[0];
        }

        return {
            create,
            inherits,
            set,
            print
        }
    }
}