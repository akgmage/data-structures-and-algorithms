//! 28/01/2022

let grid = [
    [5,3,0,0,7,0,0,0,0],
    [6,0,0,1,9,5,0,0,0],
    [0,9,8,0,0,0,0,6,0],
    [8,0,0,0,6,0,0,0,3],
    [4,0,0,8,0,3,0,0,1],
    [7,0,0,0,2,0,0,0,6],
    [0,6,0,0,0,0,2,8,0],
    [0,0,0,4,1,9,0,0,5],
    [0,0,0,0,8,0,0,7,9]
];
function display(grid) {
    let result = "__ \n"
    for(let i = 0; i < 9; i++) {
        for(let j = 0; j < 9; j++) {
            result += grid[i][j] + " | ";
        }
        result += "\n";
    }
    console.log(result);
}

function isSafe(i, j, num) { //! for the ith row, go to all possible columns.
    for(let c = 0; c < 9; c++) {
        if(grid[i][c] == num) return false;
    }
    for(let r = 0; r < 9; r++) {
        if(grid[r][j] == num) return false;
    }   
    let sr = (Math.floor(i/3))*3;
    let sc = (Math.floor(j/3))*3;
    for(let x = 0; x < 3; x++) {
        for(let y = 0; y < 3; y++) {
            if(grid[sr + x][sc + y] == num) return false;
        }
    }
    return true;
}

function solve(i, j) {
    if(i == 8 && j == 8) { //! base case
        if(grid[i][j] != 0) {
            display(grid);
            return;
        } else {
            for(let num = 1; num <= 9; num++) {
                if(isSafe(i, j, num)) {
                    grid[i][j] = num;
                    display(grid);
                    return;
                }
            }
            return;
        }
    }
    if(j >= 9) {
        solve(i + 1, 0);
        return;
    }
    if(i >= 9) return;
    
    if(grid[i][j] == 0) {
        for(let num = 1; num <= 9; num++) {
            if(isSafe(i, j, num)) {
                grid[i][j] = num;
                solve(i, j + 1);
                grid[i][j] = 0; //! reset
            }
        }
    } else {
        solve(i, j + 1);
    }
}
 
solve(0, 0);
                      