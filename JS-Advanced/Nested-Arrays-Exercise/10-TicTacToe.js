function solution(moves) {
    let board = [
        [false, false, false],
        [false, false, false],
        [false, false, false],
    ];

    const playerX = 'X';
    const playerO = 'O';

    let isX = true;

    for (let i = 0; i < moves.length; i++) {
        let r = Number(moves[i].charAt(0));
        let c = Number(moves[i].charAt(2));

        if (board[r][c] !== false) {
            console.log('This place is already taken. Please choose another!');
            continue;
        }

        if (isX) {
            board[r][c] = playerX;
            isX = false;
        } else {
            board[r][c] = playerO;
            isX = true;
        }

        let currentPlayer = isX ? playerO : playerX;
        if (hasWon(currentPlayer, board)) {
            printResult(currentPlayer, board);
            break;
        }

        if (![...board[0], ...board[1], ...board[2]].includes(false)) {
            printResult(null, board);
            break;
        }

    }

    function hasWon(player, board) {
        let magicSquare = [
            [2, 7, 6],
            [9, 5, 1],
            [4, 3, 8]
        ];

        for (let j = 0; j < 3; j++) {
            for (let k = 0; k < 3; k++) {
                if (board[j][k] !== player) {
                    magicSquare[j][k] = 0;
                }
            }
        }

        let directions = [];

        let columns = []; // get all columns
        for (let i = 0; i < 3; i++) {
            columns.push(magicSquare.map((e1, e2) => e1[i]))
        }

        for (let i = 0; i < 3; i++) { // get sums of all rows and columns
            directions.push(magicSquare[i].reduce((e1, e2) => e1 + e2));
            directions.push(columns[i].reduce((e1, e2) => e1 + e2));
        }

        let mainDiagonal = 0; // get sums of diagonals
        let secondaryDiagonal = 0;
        for (let j = 0; j < 3; j++) {
            mainDiagonal += magicSquare[j][j];
            secondaryDiagonal += magicSquare[j][2 - j];
        }
        directions.push(mainDiagonal);
        directions.push(secondaryDiagonal);

        return directions.includes(15); //if any direction == 15 player has won
    }

    function printResult(player, board) {
        if (player != null) {
            console.log(`Player ${player} wins!`);
        } else {
            console.log('The game ended! Nobody wins :(');
        }
        for (const row of board) {
            console.log(row.join('\t'));
        }
    }
}