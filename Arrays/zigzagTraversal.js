 let zigzagTraversal = (array) => {
    const height = array.length - 1;
    const width = array[0].length - 1;
    const result = [];
     row = 0;
     col = 0;   // ! O(n) time | O(n) space
     goingDown = true;

         while(!(row < 0 || row > height || col < 0 || col > width)) {
        result.push(array[row][col]);

        if (goingDown) {
                            if (col == 0 || row == height) {
                                goingDown = false;
                                if (row == height) {
                                    col += 1;
                                }
                                 else {
                                     row += 1;
                                 }
                            }
                            else {
                                row += 1;
                                col -= 1;
                            }

        }
        else {
            if (row == 0 || col == width) {
                goingDown = true;
                if (col == width) {
                    row += 1;
                } else {
                    col += 1;
                }
            } else {
                row -= 1;
                col += 1;
                }
             
        }

         }
        console.log(result);
}

function isOutOfBound (row, col, height, width) {
        return !(row < 0 || row > height || col < 0 || col > width);
}       

let arr = [ 
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9],
            [1, 2, 3, 4, 5, 6, 7, 8, 9]          
                                        ];
zigzagTraversal(arr);


