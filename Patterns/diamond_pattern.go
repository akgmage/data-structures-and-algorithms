/*
In this code, the user enters a number, and the program will print a diamond pattern with that number as the widest point.

Explanation of the approach:
- We define two helper functions: `printSpaces` and `printStars`. These functions are used to print the desired spaces and stars, respectively.
- The `printDiamondPattern` function takes an integer `n` as input. It prints the upper half and lower half of the diamond pattern using a combination of spaces and stars.
- In the upper half, the number of spaces in each row decreases by 1, while the number of stars increases by 2.
- In the lower half, the number of spaces in each row increases by 1, while the number of stars decreases by 2.
- The `main` function prompts the user to enter a number and calls the `printDiamondPattern` function to print the diamond pattern.

Time Complexity: The time complexity of this code is O(n^2), where n is the number entered by the user. This is because there are two nested loops used to print the diamond pattern.

Space Complexity: The space complexity of this code is O(1), as there are no additional data structures used that depend on the input size.

Sample Input:
Enter a number for the widest point of the diamond: 5

Sample Output:
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

*/


package main

import (
	"fmt"
	"math"
)

func printSpaces(num int) {
	for i := 1; i <= num; i++ {
		fmt.Print(" ")
	}
}

func printStars(num int) {
	for i := 1; i <= num; i++ {
		fmt.Print("* ")
	}
}

func printDiamondPattern(n int) {
	// upper half of the diamond
	for i := 0; i < n; i++ {
		printSpaces(n - i - 1)
		printStars(2*i + 1)
		fmt.Println()
	}

	// lower half of the diamond
	for i := 0; i < n-1; i++ {
		printSpaces(i + 1)
		printStars(2*(n-i-1) - 1)
		fmt.Println()
	}
}

func main() {
	var num int
	fmt.Print("Enter a number for the widest point of the diamond: ")
	fmt.Scan(&num)

	printDiamondPattern(num)
}

