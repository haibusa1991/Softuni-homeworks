function attachEventsListeners() {
    document.getElementById('convert').addEventListener('click', onClick);

    function onClick() {
        let inputDistance = Number(document.getElementById('inputDistance').value);
        let inputUnits = Array.from(document.getElementById('inputUnits').children)
            .filter(e=>e.selected)[0].textContent;

        let outputUnits = Array.from(document.getElementById('outputUnits').children)
            .filter(e => e.selected)[0].textContent;

        let multipliers = {
            'Kilometers': 1000,
            'Meters': 1,
            'Centimeters': 0.01,
            'Millimeters': 0.001,
            'Miles': 1609.34,
            'Yards': 0.9144,
            'Feet': 0.3048,
            'Inches': 0.0254
        }

        let inputDistanceInMeters = inputDistance * multipliers[inputUnits];
        let outputDistance = inputDistanceInMeters / multipliers[outputUnits];

        document.getElementById('outputDistance').value = outputDistance;
    }
}