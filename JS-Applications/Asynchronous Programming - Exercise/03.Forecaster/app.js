function attachEvents() {
    document.getElementById('submit').addEventListener('click', onClick);
}

async function onClick() {
    let location = document.getElementById('location').value;

    let locationData = await ((await fetch(`http://localhost:3030/jsonstore/forecaster/locations`)).json());

    let code = getLocationCode(locationData, location);
    if (code === null) {
        onError();
        return;
    }

    setTodayWeather(code);
    setForecastWeather(code);
}

function getLocationCode(locationData, location) {
    for (let loc of locationData) {
        if (loc.name === location) {
            return loc.code;
        }
    }
    return null;
}

async function setTodayWeather(code) {
    let weatherTodayData = await ((await fetch(`http://localhost:3030/jsonstore/forecaster/today/${code}`)).json());
    document.getElementById('current').innerHTML = '<div class="label">Current conditions</div>'
    document.getElementById('forecast').style.display = 'block';

    let locationName = weatherTodayData.name;
    let condition = weatherTodayData.forecast.condition;
    let high = weatherTodayData.forecast.high;
    let low = weatherTodayData.forecast.low;

    let forecastDiv = document.createElement('div');
    forecastDiv.classList.add('forecasts');
    document.getElementById('current').appendChild(forecastDiv)

    let symbolSpan = getSpan(icons[condition.toLowerCase()], 'condition', 'symbol');
    forecastDiv.appendChild(symbolSpan);

    let forecastSpan = getSpan('','condition');//try me
    forecastDiv.appendChild(forecastSpan);
    forecastSpan.appendChild(getSpan(locationName, 'forecast-data'));
    forecastSpan.appendChild(getSpan(`${low}${icons["degrees"]}/${high}${icons["degrees"]}`, 'forecast-data'));
    forecastSpan.appendChild(getSpan(condition, 'forecast-data'));
}

async function setForecastWeather(code) {
    let weatherForecastData = await ((await fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${code}`)).json());
    document.getElementById('upcoming').innerHTML = '<div class="label">Three-day forecast</div>'

    let upcomingDiv = document.getElementById('upcoming');

    let forecastInfo = document.createElement('div');
    forecastInfo.classList.add('forecast-info');
    upcomingDiv.appendChild(forecastInfo);

    for (let day of weatherForecastData.forecast) {
        let upcoming = getSpan('', 'upcoming');
        upcoming.appendChild(getSpan(icons[day.condition.toLowerCase()], 'symbol'));
        upcoming.appendChild(getSpan(`${day.low}${icons["degrees"]}/${day.high}${icons["degrees"]}`, 'forecast-data'));
        upcoming.appendChild(getSpan(day.condition, 'forecast-data'));
        forecastInfo.appendChild(upcoming);
    }

}

function onError() {
    document.getElementById('forecast').style.display = 'block';
    document.getElementById('current').querySelector('div').textContent = 'Error';
}

function getSpan(contents, ...spanClasses) {
    let span = document.createElement('span');
    spanClasses.forEach(e => span.classList.add(e))
    span.innerHTML = contents;
    return span;
}

let icons = {
    'sunny': '&#x2600;',
    'partly sunny': '&#x26C5;',
    'overcast': '&#x2601;',
    'rain': '&#x2614;',
    'degrees': '&#176;'
}

attachEvents();