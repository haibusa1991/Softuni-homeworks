function solution(commands) {
    let number = 0;
    let arr = [];

    for (const command of commands) {
        number++;
        switch (command) {
            case 'add':
                arr.push(number);
                break;
            case 'remove':
                arr.pop();
                break;
        }
    }
    if (arr.length === 0) {
        console.log('Empty')
    } else {
        console.log(arr.join('\n'));;
    }
}
