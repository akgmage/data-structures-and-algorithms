// Program to find factorial till a given number
function factorialIterative(number) {
    var factorialResult = 1;

    if (number == 0) {
        return 0;
    }

    for (i = 1; i <= number; i++) {
        factorialResult *= i;
    }
    return factorialResult;
}

// Driver code
console.log(factorialIterative(2));
console.log(factorialIterative(3));
console.log(factorialIterative(4));
console.log(factorialIterative(5));
