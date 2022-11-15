class TicketsRepo {
    private tickets: Ticket[];
    private sortCriteria: string;


    constructor(tickets: string[], sortCriteria: string) {
        this.sortCriteria = sortCriteria;
        this.tickets = [];
        this.populateTickets(tickets);
    }

    private populateTickets(ticketsData: string[]) {
        for (let ticket of ticketsData) {
            let [destination, price, status] = ticket.split('|');
            this.tickets.push(new Ticket(destination, price as unknown as number, status));
        }
    }

    private sortTickets(sortCriteria: string) {
        this.tickets.sort((e1, e2) => {
            switch (sortCriteria) {
                case 'destination':
                    return e1.getDestination().localeCompare(e2.getDestination());
                case 'status':
                    return e1.getStatus().localeCompare(e2.getStatus());
                case 'price':
                    return +e1.getPrice() - +e2.getPrice();
            }
        })
    }

    public getSorted() {
        this.sortTickets(this.sortCriteria);
        return this.tickets;
    }
}

class Ticket {
    private destination: string;
    private price: number;
    private status: string;


    constructor(destination: string, price: number, status: string) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }

    getDestination() {
        return this.destination;
    }

    getPrice() {
        return this.price;
    }

    getStatus() {
        return this.status;
    }
}

// let repo = new TicketsRepo([
//         'Philadelphia|94.20|available',
//         'New York City|95.99|available',
//         'New York City|95.99|sold',
//         'Boston|126.20|departed'
//     ],
//     'destination'
// );
// console.log(repo.getSorted());

let repo2 = new TicketsRepo(
    [
        'Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'
    ],
    'price'
)
console.log(repo2.getSorted());