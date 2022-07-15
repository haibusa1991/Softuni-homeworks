async function getInfo() {
    let busNumber = document.getElementById('stopId').value;

    let stopName = document.getElementById('stopName');
    let busesUl = document.getElementById('buses');

    let response;

    if (busNumber === '') {
        setError();
        return;
    }

    try {
        response = await fetch(`http://localhost:3030/jsonstore/bus/businfo/${busNumber}`);
    } catch (err) {
        setError();
    }

    if (response.status === 204) {
        setError();
        return;
    }

    let data = await response.json();
    setStopData();

    function setError() {
        stopName.textContent = 'Error';
        busesUl.innerHTML = '';
    }

    function setStopData() {
        stopName.textContent = data.name;
        busesUl.innerHTML = '';
        for (let [num, arrivesIn] of Object.entries(data.buses)) {
            let li = document.createElement('li');
            li.textContent = `Bus ${num} arrives in ${arrivesIn} minutes`;
            busesUl.appendChild(li);
        }
    }

}