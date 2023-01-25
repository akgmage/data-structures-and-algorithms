//! 29/01/2022 convert 1D to 2D;



let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];


let r = 2;
let c = 5;

//! my logic
// function printMe(r, c) {
//     let res = "";
//     for(let i = 0; i < r; i++) {
//         for(let j = 0; j < c; j++) {
//             res += arr[c*i + j] + " ";
//         }
//         res += "\n";
//     }
//     return res;
// }

// console.log(printMe(r, c));

//! sanket's logic
function convert(arr, r, c) {
    let mat = [];
    for(let i = 0; i < r; i++) {
        mat.push(Array(c));
    }
    let ptr = 0;
    for(let i = 0; i < r; i++) {
        for(let j = 0; j < c; j++) {
            if(ptr < arr.length) {
                mat[i][j] = arr[ptr++];
            }
            
        }
    }
    return mat;
}

console.log(convert(arr, r, c));