let n = 11;
let row = 0;

for (row; row <= Math.floor(n/2); row++) {
     let result = "";

      for (let spaces = 0; spaces < (n - (2*row + 1)); spaces++) {
        result = result + " ";
    }
    for (let i = 1; i <= row+1; i++) {
        result = result + i + " ";
    }
    for (let j = row; j >= 1; j-- ) {
    result = result + j + " ";
}
    console.log(result);
}
for (row; row < n; row++) {

    let result = "";

    for (let spaces = 0; spaces < (n - (2*(n - row) - 1)); spaces++ ) {
        result = result + " ";
    }
    for (let i = 1; i <= (n - row ); i++) {
        result = result + i + " ";
    }
    for (let i = ((n - row) - 1); i > 0; i--) {
        result = result + i + " ";
    }
    console.log(result);
}