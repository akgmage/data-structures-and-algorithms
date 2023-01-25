
function alphaSystem(str) {
    let len = str.length - 1;

    let result = 0;

    for(let i = 0; i < str.length; i++) {
        const char = str[i];
        const val = ALPHA[char];

        result += val * (26 ** len--);
    }
  
    return result;
}

const ALPHA = {
    'A': 1,
    'B': 2,
    'C': 3,
    'D': 4,
    'E': 5,
    'F': 6,
    'G': 7,
    'H': 8,
    'I': 9,
    'J': 10,
    'K': 11,
    'L': 12,
    'M': 13,
    'N': 14,
    'O': 15,
    'P': 16,
    'Q': 17,
    'R': 18,
    'S': 19,
    'T': 20,
    'U': 21,
    'V': 22,
    'W': 23,
    'X': 24,
    'Y': 25,
    'Z': 26
}

const str = "AA"
console.log(alphaSystem(str));



function alphaNum(str) {
    let decimalNum = 0;
    for(let i = 0; i < str.length; i++) {
    const unitVal = Math.pow(26, str.length - i - 1);
    const currentIdxVal = str[i].charCodeAt(0) - 64;
    decimalNum += unitVal * currentIdxVal;
    }
    return decimalNum;
}

console.log(alphaNum('ABC'));

