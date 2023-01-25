//! https://leetcode.com/problems/rotate-image/
//! https://www.geeksforgeeks.org/turn-an-image-by-90-degree/


// O(n * m) time  
function rotateImage(matrix) {

    let rotatedMatrix = matrix;
    let len = matrix.length - 1;

    // for(let row = 0; row < matrix.length; row++) {
    //     for(let col = 0; col < matrix[0].length; col++) {
    //         rotatedMatrix[col][len - row] = matrix[row][col];
    //     }
    // }
    // return rotatedMatrix;

    for(let row = 0; row < matrix.length; row++)
        for(let col = row; col < matrix[row].length; col++)
            [matrix[row][col], matrix[col][row] ]= [matrix[col][row], matrix[row][col]];

    for(let row = 0; row < matrix.length; row++)
        matrix[row].reverse();

    return matrix;

}


const matrix = [ [1, 2, 3], [4, 5, 6], [7, 8, 9] ];;

console.log(rotateImage(matrix));