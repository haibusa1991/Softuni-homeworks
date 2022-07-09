function solution(namesArr) {
    namesArr.sort((e1,e2) => e1.toLowerCase().localeCompare(e2.toLowerCase()));
    for (const name of namesArr) {
        console.log(namesArr.indexOf(name)+1 + '.' + name);
    }
}