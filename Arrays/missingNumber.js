function findMissingNumber(array) {
    array.sort((a, b) => a - b)
    
    for(let i = 0; i < array.length - 1; i++) {
        const j = i + 1;
        if(array[j] - array[i] != 1) {
            return array[i] + 1;
        }
    }
}

function getMissing(array, n = array.length) {
    let total = Math.floor( (n + 1) * (n + 2) / 2);
    for(let i = 0; i < array.length; i++) {
        total -= array[i];
    }
    return total
}

const array = [1, 2, 5, 6, 7, 8, 3];
console.log(getMissing(array));