/*
Approach and Explanation:
The factorial of a non-negative integer `n` is given by the product of all positive integers less than or equal to `n`. The factorial function is typically implemented using recursion. In this implementation, we check the base case where the input `n` is less than or equal to 1, and in that case, we return 1. Otherwise, we recursively call the factorial function with `n-1` and multiply it with `n`. This process continues until the base case is reached.

The code prompts the user to enter a number, reads the input, and then calls the `factorial` function to calculate the factorial of the entered number. The result is then printed on the console.

Time and Space Complexity:
The time complexity of this implementation is O(n) because the recursive function is called once for each integer from `n` to 1.

The space complexity is O(n) as well since each recursive call adds a new frame to the call stack.

Sample Input and Output:
Enter a number: 5
The factorial of 5 is: 120
*/


package main

import (
	"fmt"
)

// Function to calculate the factorial of a number
func factorial(n int) int {
	if n <= 1 {
		return 1
	}
	return n * factorial(n-1)
}

func main() {
	// Getting user input
	var number int
	fmt.Print("Enter a number: ")
	fmt.Scanln(&number)

	// Calculating and printing the factorial
	result := factorial(number)
	fmt.Printf("The factorial of %d is: %d\n", number, result)
}


