// function fun(array) {
//     let counter = Infinity;
//     for(let i = 0; i < array.length; i++) {
//         let sum = 0;
//         if(isPowerOf2(array[i])) {
//             return 1;
//         }else {
//             let temp = 1;
//             sum = sum + array[i];
//             for(var j = 0; j < array.length; j++) {
//                if(i != j) {
//                 sum = sum + array[j];
//                 if(isPowerOf2(sum)) {
//                     temp++;
//                     counter = Math.min(counter, temp);
//                     break;
//                 } else {
//                     sum = sum - array[j];
//                     temp--;
//                 }
//                }
//             }
//         }
//     }
//     return counter == Infinity? -1: counter;
// }

// function isPowerOf2(n) {
//     if(n == 1) return true;
// return parseInt( (Math.ceil((Math.log(n) / Math.log(2))))) == parseInt( (Math.floor(((Math.log(n) / Math.log(2))))));
// }

// const array = [1, 2, 3, 1];

// console.log(fun(array));
// var numJewelsInStones = function(jewels, stones) {
    
//     const obj = {};
//     let counter = 0;
    
//     for(let i = 0; i < jewels.length; i++) {
//         obj[jewels[i]] = true;
//     }
    
//     for(let i = 0; i <  stones.length; i++) {
//         const temp = stones[i];
//         if(obj[temp]) {
//             console.log(obj);
//             counter++;
//         }
//     }
//     return counter;
// };

//  const jewels = "aA";
//  const stones = "aAAbbbb";


//  console.log(numJewelsInStones(jewels, stones))



function phoneNumberMnemonics(phoneNumber) {
    if(!phoneNumber) return [];
    const currentMnemonic = new Array(phoneNumber.length).fill('0');
    const mnemonicsFound = [];
    phoneNumberMnemonicsHelper(0, currentMnemonic, phoneNumber, mnemonicsFound);
    return mnemonicsFound;
}

function phoneNumberMnemonicsHelper(idx, currentMnemonic, phoneNumber, mnemonicsFound) {

    if(idx == phoneNumber.length) {
        currentMnemonic = currentMnemonic.join('');
        mnemonicsFound.push(currentMnemonic);
        return;
    } else {
        const digit = phoneNumber[idx];
        const letters = DIGIT_LETTERS[digit];
        for(const letter of letters) {
            currentMnemonic[idx] = letter;
            phoneNumberMnemonicsHelper(idx + 1, currentMnemonic, phoneNumber, mnemonicsFound);
        }
    }
} 

const DIGIT_LETTERS = {
    1: ['1'],
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z'],
    0: ['0']
}


console.log(phoneNumberMnemonics('2'));