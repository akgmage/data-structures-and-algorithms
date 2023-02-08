// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// Time complexity: O(log n) | Space complexity: O(log n)

function pow(x, n) {
  // Any number raised to 0 is 1)
  if (n === 0) return 1
  // Power of a negative number is the reciprocal of power of positive number
  if (n < 0) return 1 / pow(x, -n)
  // If n is even, calculate pow(x, n / 2) and return the square of it
  if (n % 2 === 0) return pow(x, n / 2) * pow(x, n / 2)
  // If n is odd, return x * pow(x, n - 1) (x raised to odd power n can be represented as x * x^(n-1))
  return x * pow(x, n - 1)
}

// Sample inputs and outputs
console.log(pow(2, 10)) // 1024
console.log(pow(2, -3)) // 0.125
console.log(pow(3, 3)) // 27
console.log(pow(3, 0)) // 1