function solution(speed, area) {
    let speedLimit = 0;
    switch (area) {
        case 'residential':
            speedLimit = 20;
            break;
        case 'city':
            speedLimit = 50
            break;
        case 'interstate':
            speedLimit = 90;
            break;
        case 'motorway':
            speedLimit = 130;
            break;
    }

    let message = "";
    let difference = speed - speedLimit;
    if (difference <= 0) {
        message = `Driving ${speed} km/h in a ${speedLimit} zone`;
    } else if (difference > 0 && difference <= 20) {
        message = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - speeding`;
    } else if (difference > 20 && difference <= 40) {
        message = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`;
    } else {
        message = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - reckless driving`;
    }

    console.log(message);
}

solution(40, 'city');
solution(21, 'residential');
solution(120, 'interstate');
solution(200, 'motorway');