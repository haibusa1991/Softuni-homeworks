function solution(r, c) {
    let matrix = initMatrix(r, c)

    let currentRow = 0;
    let currentColumn = -1;
    for (let i = 0; i < r * c;) {
        while (hasRight(currentRow, currentColumn, matrix)) {
            currentColumn++;
            i++;
            matrix[currentRow][currentColumn] = i;
        }

        while (hasBottom(currentRow, currentColumn, matrix)) {
            currentRow++;
            i++;
            matrix[currentRow][currentColumn] = i;
        }

        while (hasLeft(currentRow, currentColumn, matrix)) {
            currentColumn--;
            i++;
            matrix[currentRow][currentColumn] = i;
        }

        while (hasTop(currentRow, currentColumn, matrix)) {
            currentRow--;
            i++;
            matrix[currentRow][currentColumn] = i;
        }
    }

    for (let row of matrix) {
        console.log(row.join(' '));
    }


    function hasRight(r, c, matrix) {
        return (c + 1 < matrix[r].length && matrix[r][c + 1] === 0);
    }

    function hasBottom(r, c, matrix) {
        return (r + 1 < matrix.length && matrix[r + 1][c] === 0);
    }

    function hasLeft(r, c, matrix) {
        return (c - 1 >= 0 && matrix[r][c - 1] === 0);
    }

    function hasTop(r, c, matrix) {
        return (r - 1 >= 0 && matrix[r - 1][c] === 0);
    }

    function initMatrix(r, c) {
        let row = [];

        for (let i = 0; i < c; i++) {
            row.push(0);
        }

        let matrix = [];
        for (let i = 0; i < r; i++) {
            matrix.push([...row]);
        }

        return matrix;
    }
}