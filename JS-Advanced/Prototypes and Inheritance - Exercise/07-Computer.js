function solution() {
    class BaseItem {
        constructor(manufacturer) {
            this.manufacturer = manufacturer;
        }
    }

    class Keyboard extends BaseItem {
        constructor(manufacturer, responseTime) {
            super(manufacturer);
            this.responseTime = responseTime;
        }
    }

    class Monitor extends BaseItem {
        constructor(manufacturer, width, height) {
            super(manufacturer);
            this.width = width;
            this.height = height;
        }
    }

    class Battery extends BaseItem {
        constructor(manufacturer, expectedLife) {
            super(manufacturer);
            this.expectedLife = expectedLife;
        }
    }

    class Computer extends BaseItem {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace) {
            super(manufacturer);
            this.processorSpeed = processorSpeed;
            this.ram = ram;
            this.hardDiskSpace = hardDiskSpace;

            if (this.constructor === Computer) {
                throw new Error("Abstract classes can't be instantiated.");
            }
        }
    }

    class Laptop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.weight = weight
            this.color = color
            this.battery = battery
        }

        set battery(value) {
            if (!(value instanceof Battery)) {
                throw new TypeError('Object passed to battery parameter should be of class Battery')
            }

            this._battery = value;
        }

        get battery() {
            return this._battery;
        }
    }

    class Desktop extends Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor) {
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.keyboard = keyboard
            this.monitor = monitor
        }

        set keyboard(value) {
            if (!(value instanceof Keyboard)) {
                throw new TypeError('Object passed to battery keyboard should be of class Keyboard')
            }

            this._keyboard = value;
        }

        get keyboard() {
            return this._keyboard;
        }

        set monitor(value) {
            if (!(value instanceof Monitor)) {
                throw new TypeError('Object passed to monitor keyboard should be of class Monitor')
            }

            this._monitor = value;
        }

        get monitor() {
            return this._monitor;
        }
    }

    return {
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    }
}

let classes = solution();
let Computer = classes.Computer;
let Laptop = classes.Laptop;
let Desktop = classes.Desktop;
let Monitor = classes.Monitor;
let Battery = classes.Battery;
let Keyboard = classes.Keyboard;

let battery = new Battery('Energy', 3);
console.log(battery);
let laptop = new Laptop("Hewlett Packard", 2.4, 4, 0.5, 3.12, "Silver", battery);
console.log(laptop);
