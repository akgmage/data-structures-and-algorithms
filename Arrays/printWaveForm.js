let a = [ [1, 2, 3, 4], 
          [2, 3, 4, 5], 
          [3, 4, 5, 6],
          [40, 50, 60, 70]];



function wavePrint(arr) {
    let n = arr.length;
    let m = arr[0].length;
    let result = "";
    for(let col = 0; col < m; col++) {
        if(col % 2 == 0) {
            //! even column
            for(let row = 0; row < n; row++) {
                result += arr[row][col] + " ";
            }           
        } else {
            //! odd column
            for(let row = n - 1; row >= 0; row--) {
                result += arr[row][col] + " ";
            }
        }
    }
    return result;
}

console.log(wavePrint(a));