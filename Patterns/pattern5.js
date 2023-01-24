let n = 4;
let row = 1;

for (row; row <= n; row++) {
    
    let result = "";
    for (let spaces = 1; spaces <= 2*(n - row); spaces++) {
        result = result + " ";
    }
for (let i = 1; i <= row; i++ ) {
       result = result + i + " ";
}
for (let j = row - 1; j >= 1; j-- ) {
    result = result + j + " ";
}
 console.log(result);

}
