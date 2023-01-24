let n = 4;
let row = 1;
let i = 0;

for (row; row <= n; row++) {
    
    let result = "";
    for (let spaces = 1; spaces <= 2*(n - row); spaces++) {
        result = result + " ";
    }
for (i ; i < row; i++ ) {
       result = result + (i+1) + " ";
}
// i = i-1;
// for (let j = row - 1; j >= 1; j-- ) {
//     result = result + j + " ";
// }
 console.log(result);

}
