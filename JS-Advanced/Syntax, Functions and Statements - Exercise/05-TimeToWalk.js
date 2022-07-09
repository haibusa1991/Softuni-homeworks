function solution(stepsCount, footprintMeters, speedKmh) {
    let distance = stepsCount * footprintMeters;
    let numBreaks = Math.floor(distance / 500);
    let walkTimeSeconds = distance / (speedKmh / 3.6) + numBreaks * 60;

    let hours = Math.floor(walkTimeSeconds / 3600);
    let minutes = Math.floor((walkTimeSeconds - hours * 3600) / 60);
    let seconds = Number((walkTimeSeconds % 60).toFixed(0));

    console.log(`${hours > 9 ? '' : '0'}${hours}:${minutes > 9 ? '' : '0'}${minutes}:${seconds > 9 ? '' : '0'}${seconds}`);
}

solution(4000, 0.60, 5);
solution(2564, 0.70, 5.5);
solution(256400, 0.70, 5.5);