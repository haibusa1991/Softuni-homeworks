function solution(inputPies, startPie, endPie) {
    return inputPies.slice(inputPies.indexOf(startPie), inputPies.indexOf(endPie)+1);
}