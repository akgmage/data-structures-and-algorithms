// Whether the given number is a prime nujmber or not
// Time complexity O(n)
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

// Time complexity: O(sqrt(n))
// Space complexity: O(1)
const isPrime = (num) => {
  for (let i = 2, s = Math.sqrt(num); i <= s; i++) {
    if (num % i === 0) return false;
  }
  return num > 1;
};

console.log(isPrime(10));

// Time complexity - O(logn)
function isPrimeLogn(input) {
  for (i = 2; i < Math.sqrt(input); i++) {
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
console.log(isPrimeLogn(7));
