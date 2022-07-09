function solve(input) {
    let proc = processor();

    for (const item of input) {
        let tokens = item.split(' ');
        let command = tokens[0];
        let value = tokens[1];

        proc[command](value);
    }


    function processor() {
        let state = [];

        function add(string) {
            state.push(string);
        }

        function remove(string) {
            state = state.filter(e => e !== string);
        }

        function print() {
            console.log(state.join(','));
        }

        return {
            add,
            remove,
            print
        }
    }
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solve(['add pesho', 'add george', 'add peter', 'remove peter','print'])