/*
? process.stdin.resume();
? process.stdin.setEncoding('utf-8');
? 
? let inputString = "";
 ! data is an event
? process.stdin.on('data', function(userInput) {
?     inputString += userInput;
?     console.log(inputString);
? })
? 
? process.stdin.on('end', function(x) {
?     inputString.trim();
?     main();
? });
? 
? function main() {
?     
? }
? 
*/


process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = "";
let currentLine = 0; 
//! data is an event
process.stdin.on('data', function(userInput) {
    inputString += userInput;
    // console.log(inputString);
})

process.stdin.on('end', function() {
    inputString.trim();
    inputString = inputString.split("\n");
    main();
});

function readline() {
    return result = inputString[currentLine++]; //! 0++
}

function processArray(arr) {
    let temp = arr.split(" ");
    let result = [];
    for(let i = 0; i < temp.length; i++) {
        result.push(Number(temp[i]));
    }
    return result;
}

function main() {

    let t = Number(readline()); //! here t is currentLine[0];
 
    while(t > 0) {
        let n = Number(readline());
        let arr = readline();
        arr = processArray(arr);
        let k = Number(readline());
        console.log("length of array:", n);
        console.log(typeof arr);
        console.log("k is", k);
        t = t - 1;
    }
}