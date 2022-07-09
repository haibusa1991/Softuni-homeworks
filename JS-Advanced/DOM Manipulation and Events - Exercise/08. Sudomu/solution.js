function solve() {
    let checkButton = document.querySelectorAll('button')[0];
    let clearButton = document.querySelectorAll('button')[1];

    checkButton.addEventListener('click', onCheck);
    clearButton.addEventListener('click', onClear);

    function onCheck() {
        let matrix = readValues();
        let isValid = validate(matrix);

        if (isValid) {
            setGameState('Green');
            return;
        }
        setGameState('Red');
    }

    function onClear() {
        setGameState('None');
    }

    function readValues() {
        let matrix = [];
        let rows = Array.from(document.querySelectorAll('tbody tr'))

        for (let i = 0; i < rows.length; i++) {
            let currentRow = Array.from(rows[i].children)
                .map(e => e.querySelector('input'))
                .map(e => e.value);

            matrix.push(currentRow);
        }
        return matrix;
    }

    function validate(matrix) {
        for (let r = 0; r < matrix.length; r++) {
            for (let c = 0; c < matrix[r].length; c++) {
                for (let v = c; v < matrix[r].length - 1; v++) {
                    // console.log(`comparing ${matrix[r][c]} with ${matrix[r][v + 1]} on row ${r + 1}`)
                    if (matrix[r][c] === matrix[r][v + 1]
                        || matrix[r][v] < 1
                        || matrix[r][v] > matrix.length) {
                        // console.log('invalid')
                        return false;
                    }
                }
            }
        }

        for (let c = 0; c < matrix.length; c++) {
            for (let r = 0; r < matrix.length; r++) {
                for (let v = r; v < matrix.length - 1; v++) {
                    // console.log(`comparing ${matrix[r][c]} with ${matrix[v+1][c]} on column ${c + 1}`)
                    if (matrix[r][c] === matrix[v + 1][c]
                        || matrix[v + 1][c] < 1
                        || matrix[v + 1][c] > matrix.length) {
                        // console.log('invalid')
                        return false;
                    }
                }
            }
        }

        // console.log('is valid')
        return true;
    }

    function setGameState(tableState) {
        let table = document.querySelector('table');
        let text = document.getElementById('check').querySelector('p');

        let tableStates = {
            Red: ['2px solid red', 'NOP! You are not done yet...', 'red'],
            Green: ['2px solid green', "You solve it! Congratulations!", 'green'],
            None: ['', '', '']
        }

        table.style.border = tableStates[tableState][0];
        text.textContent = tableStates[tableState][1];
        text.style.color = tableStates[tableState][2];

        if (tableStates[tableState][0] === '') {
            Array.from(document.querySelectorAll('td input'))
                .map(e => e.value = '');
        }
    }
}