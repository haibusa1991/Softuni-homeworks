function solve() {
    let currentStop = 'depot';
    let nextStop = 0;


    let departBtn = document.getElementById('depart');
    let arriveBtn = document.getElementById('arrive');
    let stopInfo = document.getElementById('info').querySelector('span');

    async function depart() {
        let data = await ((await fetch(`http://localhost:3030/jsonstore/bus/schedule/${currentStop}`)).json());
        currentStop = data.name;
        nextStop = data.next;

        stopInfo.textContent = `Next stop ${currentStop}`;

        departBtn.disabled = true;
        arriveBtn.disabled = false;

    }

    async function arrive() {
        stopInfo.textContent = `Arriving at ${currentStop}`;
        currentStop = nextStop;
        departBtn.disabled = false;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();