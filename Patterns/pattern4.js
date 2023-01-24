let n = 11;
let row = 0;

//? Upper Part
for (row; row <= Math.floor(n/2); row++) {
    
    let result = "";
    for (let spaces = 0; spaces < (n - (2*row + 1)); spaces++) {
        result = result + " ";
    }

    for (let stars = 0; stars < (2*row) + 1; stars++) {
        result = result + "* ";
    }
    console.log(result);
}

//? Lower Part

for (row; row < n; row++) {

    let result = "";

    for (let spaces = 0; spaces < (n - (2*(n - row) - 1)); spaces++) {
        result = result + " ";
    }
    for (let stars = 0; stars < (2*(n - row) - 1); stars++) {
        result = result + "* ";
    }
    console.log(result);
}