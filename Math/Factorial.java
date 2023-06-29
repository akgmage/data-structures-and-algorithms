/*
What is a factorial of a number?
The factorial of a non-negative integer n is the product of all positive integers less than or equal to n. It is denoted by n!. For example, the factorial of 5 is 5! = 5 x 4 x 3 x 2 x 1 = 120.

Approach:
The recursive approach is used to calculate the factorial. The function `factorial()` takes an integer `n` as input. In each recursive call, we check if `n` is either 0 or 1 (base case), and if so, we return 1. Otherwise, we multiply `n` with the factorial of `n-1` and return the result.

Time Complexity: O(n)
The time complexity of this algorithm is O(n) because the recursion depth is equal to n, and in each recursion, we perform a constant-time operation.

Space Complexity: O(n)
The space complexity is O(n) because, in the worst-case scenario, the recursion depth can reach up to n. So, n frames will be added to the call stack.

Sample Input: 5
Sample Output: Factorial of 5 is: 120

*/

public class Factorial {
  // Recursive function to calculate the factorial
  public static int factorial(int n) {
    // Base case: if n is 0 or 1, the factorial is always 1
    if (n == 0 || n == 1) {
      return 1;
    }
    
    // Recursive case: multiply n with factorial of (n-1)
    return n * factorial(n - 1);
  }

  public static void main(String[] args) {
    int number = 5; // Sample input: calculate factorial of 5
    int result = factorial(number);
    System.out.println("Factorial of " + number + " is: " + result);
  }
}

