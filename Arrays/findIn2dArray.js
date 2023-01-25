//! 29/01/2022
let arr = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [6, 7, 8, 9],
    [7, 8, 9, 10]
];

 function finder(row, x) {
        for(let i = 3; i >= row; i--) {
            if(arr[row][i] == x) {
                console.log(row + 1, i + 1);
                return;
            }
            
        }
        console.log("not there");
    }

function find(x) {
    let cols = arr[0].length;
    if(x <= arr[0][cols - 1]) {
        finder(0, x);
        return;
    }
    if(x <= arr[1][cols - 1]) {
         finder(1, x);
          return;
    }
    if(x <= arr[2][cols - 1]) {
         finder(2, x);
         return;
    }
    if(x <= arr[3][cols - 1]) {
         finder(3, x);
         return;
    }
    console.log(-1);
 
}


find(8.2);

 