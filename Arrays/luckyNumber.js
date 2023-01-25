// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
function luckyNumber(matrix) {

    const result = [];

    for(let row = 0; row < matrix.length; row++) {

        const min = Math.min(...matrix[row]);

        const index = matrix[row].indexOf(min);

        const colValues = [];

        for(let col = 0; col < matrix[0].length; col++) {
            colValues.push(matrix[col][index])
        }

        if(min == Math.max(...colValues)) result.push(min);
    }
    return result;
}

// const matrix = [[3,7,8],[9,11,13],[15,16,17]];
const matrix = [[7, 8], [1, 2]];


console.log(luckyNumber(matrix));
