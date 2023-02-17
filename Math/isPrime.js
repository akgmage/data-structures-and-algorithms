// Whether the given number is a prime nujmber or not

function isPrime(input) {
    for (i = 2; i < input; i++) {
        if (input % i == 0) {
            return "The number is not a prime number";
            break;
        } else {
            continue;
        }
    }
    return "Given number is a prime number";
}

// Driver code
console.log(isPrime(6));
