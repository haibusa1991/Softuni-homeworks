function solve(tickets, criterion) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    let arr = [];

    for (let ticket of tickets) {
        let [dest, price, status] = ticket.split('|');
        arr.push(new Ticket(dest, price, status));
    }

    let sorter = {
        destination: (e1, e2) => e1.destination.localeCompare(e2.destination),
        status: (e1, e2) => e1.status.localeCompare(e2.status),
        price: (e1, e2) => e1.price - e2.price
    }

    arr.sort((e1, e2) => sorter[criterion](e1, e2));

    return arr;
}

console.log(solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'price'
));