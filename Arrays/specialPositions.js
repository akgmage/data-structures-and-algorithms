// https://leetcode.com/problems/special-positions-in-a-binary-matrix/

var numSpecial = function(mat) {
    
    const rowSum = [];
    const colSum = [];
    
    // sum of all rows
    for(let i = 0; i < mat.length; i++) {
        rowSum[i] = 0;
        for(j = 0; j < mat[0].length; j++) {
            rowSum[i] += mat[i][j];
        }
    }
    // Sum of all cols
    for(let i = 0; i < mat[0].length; i++) {

        colSum[i] = 0;
        for(let j = 0; j < mat.length; j++) {
            colSum[i] += mat[j][i];
        }
    }
    let count = 0;
    for(let i = 0; i < mat.length; i++) {
        for(let j = 0; j < mat[0].length; j++) {
            if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                count += 1;
        
                }  
              }
    }
return count;
};

// const matrix = [[1, 0, 0], [0, 1, 0], [0, 0, 1] ];
// const matrix = [[0,0,0,0,0,1,0,0],
//                 [0,0,0,0,1,0,0,1],
//                 [0,0,0,0,1,0,0,0],
//                 [1,0,0,0,1,0,0,0],
//                 [0,0,1,1,0,0,0,0]];
// const matrix = [[0,0,1,0],[0,0,0,0],[0,0,0,0],[0,1,0,0]];
const matrix = [[1,0,0],[0,0,1],[1,0,0]];


console.log(numSpecial(matrix));