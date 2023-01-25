//! O(n) time | O(n) space
function zigzagTraversal(array) {
    const height = array.length - 1;
    const width = array[0].length - 1;
    let row = 0;
    let col = 0;
    const result = [];
    let goingDown = true;

    while(!isOUtOfBounds(row, col, height, width)) {
        result.push(array[row][col]);
        if(goingDown) {
            if(col == 0 || row == height) { 
                goingDown = false;
                if(row == height) {
                    col++;
                } else {
                    row++;
                }
            } else {
                row++;
                col--;
            }
        } else {
            if(row == 0 || col == width) {
                goingDown = true;
                if(col == width) {
                    row++;
                } else {
                    col++;
                }
            } else {
                row--;
                col++;
            }
        }
    } return result;
}

function isOUtOfBounds(row, col, height, width) {
    return row < 0 || row > height || col < 0 || col > width;
}

const array = [
    [1, 3, 4, 10],
    [2, 5, 9, 11],
    [6, 8, 12, 15],
    [7, 13, 14, 16]
  ];

  console.log(zigzagTraversal(array));