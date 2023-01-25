function transposeMatrix(matrix) {

    let result = [...Array(matrix[0].length)].map(e => Array(matrix.length));

    console.log(result);

    for(let i = 0; i < result.length; i++) {
        for(let j = 0; j < result[0].length; j++) {
            result[i][j] = matrix[j][i];
        }
    } 
    return result;
}

const matrix = [[1,4],[2,5],[3,6]];



console.log(transposeMatrix(matrix));


function addMatrices(matrix1, matrix2) {

    const result = [...Array(matrix1.length)].map(e => Array(matrix1[0].length));

    for(let i = 0; i < matrix1.length; i++) {
        for(let j = 0; j < matrix1[0].length; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }
    return result;
}

const matrix1 = [[4, 5],
                 [6, 7]];
const matrix2 = [[1, 2],
                 [3, 8]];

console.log(addMatrices(matrix1, matrix2));