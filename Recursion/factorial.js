// Factorial of an integer
// Sample Input: 5
// Output: 120
function recursiveFactorial(number) {
  //Base case
  if (number == 1) {
    return 1;
  }

  //recursively calling function to get factorial result
  return number * recursiveFactorial(number - 1);
}

// Driver code
console.log(recursiveFactorial(2));
console.log(recursiveFactorial(3));
console.log(recursiveFactorial(4));
console.log(recursiveFactorial(5));
