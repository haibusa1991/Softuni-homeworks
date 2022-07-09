class SmartHike {
    constructor(username) {
        this.username = username;
        this.goals = {};
        this.listOfHikes = [];
        this.resources = 100;
    }

    addGoal(peak, altitude) {
        if (this.goals[peak] !== undefined) {
            return `${peak} has already been added to your goals`;
        }

        this.goals[peak] = altitude;
        return `You have successfully added a new goal - ${peak}`;
    }

    hike(peak, time, difficultyLevel) {
        if (this.goals[peak] === undefined) {
            throw new Error(`${peak} is not in your current goals`);
        }

        if (this.resources === 0) {
            throw new Error('You don\'t have enough resources to start the hike');
        }

        let requiredResource = time * 10;
        if (this.resources < requiredResource) {
            return 'You don\'t have enough resources to complete the hike';
        }

        this.resources -= requiredResource;
        this.listOfHikes.push({peak, time, difficultyLevel});
        return `You hiked ${peak} peak for ${time} hours and you have ${this.resources}% resources left`
    }

    rest(time) {
        this.resources += time * 10;

        if (this.resources >= 100) {
            this.resources = 100;
            return `Your resources are fully recharged. Time for hiking!`;
        }

        return `You have rested for ${time} hours and gained ${time * 10}% resources`;
    }

    showRecord(criteria) {
        if (this.listOfHikes.length === 0) {
            return `${this.username} has not done any hiking yet`;
        }

        let getRecords =
            {
                easy: this.listOfHikes
                    .filter(e => e.difficultyLevel === 'easy')
                    .sort((e1, e2) => e2.time - e1.time)[0],

                hard: this.listOfHikes
                    .filter(e => e.difficultyLevel === 'hard')
                    .sort((e1, e2) => e2.time - e1.time)[0]
            }
        let hike = getRecords[criteria];

        if (hike === undefined && criteria !== 'all') {
            return `${this.username} has not done any ${criteria} hiking yet`;
        }

        if (criteria === 'all') {
            let hikes = this.listOfHikes
                .map(e => `${this.username} hiked ${e.peak} for ${e.time} hours`);
            return `All hiking records:\n${hikes.join('\n')}`;
        }

        return `${this.username}'s best ${criteria} hike is ${hike.peak} peak, for ${hike.time} hours`
    }
}

const user = new SmartHike('Vili');
user.addGoal('Musala', 2925);
user.hike('Musala', 8, 'hard');
console.log(user.showRecord('easy'));

user.addGoal('Vihren', 2914);
user.hike('Vihren', 4, 'hard');
console.log(user.showRecord('hard'));

user.addGoal('Rui', 1706);
user.hike('Rui', 3, 'easy');
console.log(user.showRecord('all'));

