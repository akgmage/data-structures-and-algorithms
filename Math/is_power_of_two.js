// Whether the provided number is power of two

// Time complexity - O(log n)
function isPowerOfTwo(inputNumber) {
    if (inputNumber <= 1) {
        return false;
    }

    var dividedNumber = inputNumber;

    while (dividedNumber !== 1) {
        if (dividedNumber % 2 !== 0) {
            return false;
        }
        dividedNumber = dividedNumber / 2;
    }
    return true;
}

// Time complexity - O(1)
function isPowerOfTwoConst(inputNumber) {
    if (inputNumber <= 1) {
        return false;
    }

    return (
        parseInt(Math.ceil(Math.log(n) / Math.log(2))) ==
        parseInt(Math.floor(Math.log(n) / Math.log(2)))
    );
}

// Time complexity - O(log n)
function isPowerOfTwoConst(inputNumber) {
    if (inputNumber <= 1) {
        return false;
    }

    return (
        parseInt(Math.ceil(Math.log(n) / Math.log(2))) ==
        parseInt(Math.floor(Math.log(n) / Math.log(2)))
    );
}

//Driver code
console.log(isPowerOfTwo(8));
console.log(isPowerOfTwo(1));
console.log(isPowerOfTwo(7));
console.log(isPowerOfTwo(6));
console.log(isPowerOfTwo(16));
console.log(isPowerOfTwo(32));
