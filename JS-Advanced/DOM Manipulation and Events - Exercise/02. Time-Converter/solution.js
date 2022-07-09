function attachEventsListeners() {
    let daysField = document.getElementById('days');
    let hoursField = document.getElementById('hours');
    let minutesField = document.getElementById('minutes');
    let secondsField = document.getElementById('seconds');

    document.getElementById('daysBtn').addEventListener('click', onClick);
    document.getElementById('hoursBtn').addEventListener('click', onClick);
    document.getElementById('minutesBtn').addEventListener('click', onClick);
    document.getElementById('secondsBtn').addEventListener('click', onClick);

    function convert(seconds) {
        return [
            seconds / 86400, // days[0]
            seconds / 3600,  // hours[1]
            seconds / 60, // minutes[2]
            seconds //seconds [3]
        ];
    }

    function onClick(event) {
        let converter = {
            daysBtn: (e) => e * 86400,
            hoursBtn: (e) => e * 3600,
            minutesBtn: (e) => e * 60,
            secondsBtn: (e) => e
        };

        let inputValue = event.target.parentElement.querySelectorAll('input')[0].value;
        inputValue = Number(inputValue);

        let seconds = converter[event.target.id](inputValue);
        let values = convert(seconds);
        setFields(values);
    }

    function setFields(values) {
        daysField.value = values[0];
        hoursField.value = values[1];
        minutesField.value = values[2];
        secondsField.value = values[3];
    }

}