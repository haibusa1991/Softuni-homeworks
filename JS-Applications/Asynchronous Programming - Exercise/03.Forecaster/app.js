function attachEvents() {
    document.getElementById('submit').addEventListener('click', onClick);
}

async function onClick() {
    let location = document.getElementById('location').value;

    let locationData = await((await fetch(`http://localhost:3030/jsonstore/forecaster/locations`)).json());

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

    let symbolSpan = getSpan('condition', icons[condition.toLowerCase()]);
    symbolSpan.classList.add('symbol');
    forecastDiv.appendChild(symbolSpan);

    let forecastSpan = getSpan('condition', '');
    forecastDiv.appendChild(forecastSpan);
    forecastSpan.appendChild(getSpan('forecast-data', locationName));
    forecastSpan.appendChild(getSpan('forecast-data', `${low}${icons["degrees"]}/${high}${icons["degrees"]}`));
    forecastSpan.appendChild(getSpan('forecast-data', condition));
}

async function setForecastWeather(code) {
    let weatherForecastData = await ((await fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${code}`)).json());
    document.getElementById('upcoming').innerHTML = '<div class="label">Three-day forecast</div>'

    let upcomingDiv = document.getElementById('upcoming');

    let forecastInfo = document.createElement('div');
    forecastInfo.classList.add('forecast-info');
    upcomingDiv.appendChild(forecastInfo);

    for (let day of weatherForecastData.forecast) {
        let upcoming = getSpan('upcoming', '');
        upcoming.appendChild(getSpan('symbol', icons[day.condition.toLowerCase()]));
        upcoming.appendChild(getSpan('forecast-data', `${day.low}${icons["degrees"]}/${day.high}${icons["degrees"]}`));
        upcoming.appendChild(getSpan('forecast-data', day.condition));
        forecastInfo.appendChild(upcoming);
    }

}

function onError() {
    document.getElementById('forecast').style.display = 'block';
    document.getElementById('current').querySelector('div').textContent = 'Error';
}

function getSpan(spanClass, contents) {
    let span = document.createElement('span');
    span.classList.add(spanClass);
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