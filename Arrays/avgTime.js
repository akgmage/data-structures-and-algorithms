function avgTime(matrix) {

    let result = 0;

    matrix.forEach(row => {
        result += (row[1] - row[0]);
    });

    return Math.round(result / matrix.length);
}

const matrix = [
            [3, 8],
            [5, 9],
            [1, 5] ];


console.log(avgTime(matrix));