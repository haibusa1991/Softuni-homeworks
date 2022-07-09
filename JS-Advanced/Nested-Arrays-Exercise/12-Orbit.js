function solution(arr) {
    let w = arr[0];
    let h = arr[1];
    let r = arr[2];
    let c = arr[3];

    let matrix = initMatrix(w, h);
    let offset = 1;
    matrix[r][c] = offset;

    while (matrix.toString().split(',').includes('0')) {
        fillTopBottom(r, c, offset, matrix);
        fillLeftRight(r, c, offset, matrix);
        offset++;
    }

    for (const row of matrix) {
        console.log(row.join(' '));
    }


    function fillTopBottom(r, c, offset, matrix) {
        let topRow = r - offset;
        let bottomRow = r + offset;
        let start = c - offset;
        let end = c + offset;

        if (topRow >= 0 && end >= 0) {
            for (let i = start; i <= end; i++) {
                if (i < 0) {
                    continue;
                }

                if (i >= matrix[topRow].length) {
                    break;
                }

                matrix[topRow][i] = offset + 1;
            }
        }

        if (bottomRow < matrix.length && end >= 0) {
            for (let i = start; i <= end; i++) {
                if (i < 0) {
                    continue;
                }

                if (i >= matrix[bottomRow].length) {
                    break;
                }

                matrix[bottomRow][i] = offset + 1;
            }
        }

    }

    function fillLeftRight(r, c, offset, matrix) {
        let leftColumn = c - offset;
        let rightColumn = c + offset;
        let start = r - offset;
        let end = r + offset - 1;

        if (leftColumn >= 0 && end >= 0) {
            for (let i = start; i <= end; i++) {
                if (i < 0) {
                    continue;
                }

                if (i >= matrix.length) {
                    break;
                }

                matrix[i][leftColumn] = offset + 1;
            }
        }

        if (rightColumn < matrix[0].length && end >= 0) {
            for (let i = start; i <= end; i++) {
                if (i < 0) {
                    continue;
                }

                if (i >= matrix.length) {
                    break;
                }

                matrix[i][rightColumn] = offset + 1;
            }
        }
    }

    function initMatrix(w, h) {
        let row = [];

        for (let i = 0; i < w; i++) {
            row.push(0);
        }

        let matrix = [];
        for (let i = 0; i < h; i++) {
            matrix.push([...row]);
        }

        return matrix;
    }
}