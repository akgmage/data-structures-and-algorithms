process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = "";
let inputString1 = "";

let currentLine = 0;

process.stdin.on('data', function(input) {
    inputString1 += input;

});

process.stdin.on('end', function(x) {
    inputString1.trim();
    inputString1 = inputString1.split("\n");

    for(let i = 0; i < inputString1.length; i++) {
        inputString += inputString1[i].trim() + ' ';
    }
    inputString.trim();
    inputString = inputString.split(" ");
    main();
})
function readline() {
    return result = inputString[currentLine++];
}

function main() {
    let math = parseInt(readline());
    let physics = parseInt(readline());
    let chemistry = parseInt(readline());

    if (math < 65 || physics < 55 || chemistry < 50  || (math + physics + chemistry < 195 && math + physics < 140))
    console.log("not eligible");
    else console.log("eligible");
}