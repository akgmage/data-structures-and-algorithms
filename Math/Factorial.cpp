/*
Explanation:
- The `factorial` function takes an integer `num` as input and calculates its factorial. The factorial of a non-negative integer N is the product of all positive integers less than or equal to N.
- In the function, we have a base case that handles the special case when `num` is 0. The factorial of 0 is defined as 1, so we return 1 for `num` equal to 0.
- For non-zero `num`, we use recursion to calculate the factorial. We call the `factorial` function with `num - 1`, and then multiply the result by `num`.
- The recursion continues until we reach the base case when `num` becomes 0, and the recursive calls start to return their values and calculate the final factorial.

Time Complexity: The time complexity of the `factorial` function is O(N), where N is the value of the input number. This is because the function makes N recursive calls to calculate the factorial.
  
Space Complexity: The space complexity is O(N) due to the recursion stack space used during the recursive calls. Each recursive call adds a new stack frame, and in the worst case, there will be N stack frames corresponding to the N recursive calls.

Sample Input:
Number: 5

Sample Output:
Factorial of 5 is 120
*/

#include <iostream>

// Function to calculate factorial
unsigned long long factorial(int num) {
    // Base case: factorial of 0 is 1
    if (num == 0) {
        return 1;
    }

    // Recursive case: calculate factorial using recursion
    return num * factorial(num - 1);
}

int main() {
    // Sample input
    int num = 5;

    // Calculate the factorial of the number
    unsigned long long result = factorial(num);

    // Print the result
    std::cout << "Factorial of " << num << " is " << result << std::endl;

    return 0;
}
