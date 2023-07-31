/*

	Given a string representation of the first n digits of Pi and a list of positive integers (all in string format), write a function that returns the
	smallest number of spaces that can be added to the n digits of Pi such that all resulting numbers are found in the list of integers.

	Sample Input pi = "3141592653589793238462643383279"
	numbers : ["314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"]

	Output: 2


	Explanation:

	The given code snippet is for solving the "Numbers in Pi" problem using a recursive approach with memoization (dynamic programming) to find the minimum number of spaces required to divide the given string representation of pi into valid numbers from a list of given numbers.

	The problem is as follows: Given a string representation of the irrational number pi and a list of numbers, find the minimum number of spaces required to divide the string into valid numbers such that each number is present in the given list.

	Let's go through the code step by step:

	1. `NumbersInPi` function:
	- This is the main function that takes the string representation of pi and a list of numbers as input and returns the minimum number of spaces required. It initializes a `numbersTable` to store the numbers from the input list for quick lookup and then calls the `getMinSpaces` function with initial parameters.

	2. `getMinSpaces` function:
	- This is a recursive function with memoization. It takes the string representation of pi, the `numbersTable`, a `cache` (a map to store previously calculated values to avoid redundant calculations), and the current `idx` (position in the pi string) as input.
	- It first checks if the base case has been reached by comparing `idx` with the length of the pi string. If so, it returns -1.
	- Next, it checks if the result for the current `idx` is already present in the cache. If yes, it returns the cached result.
	- If the base case is not reached and the result is not in the cache, it initializes a variable `minSpaces` to store the minimum spaces required for the current `idx`. It sets `minSpaces` to a large value (initialized as `math.MaxInt32`) to ensure correct comparisons later.
	- Then, it iterates from the current `idx` to the end of the pi string and forms a prefix string from `idx` to the current iteration index (`i`).
	- If the prefix string is found in the `numbersTable`, it means it is a valid number from the given list. The function then recursively calls itself with the suffix (remaining part) of the pi string starting from index `i+1`.
	- The result of the recursive call is stored in `minSpacesInSuffix`.
	- The minimum of `minSpaces` and `minSpacesInSuffix + 1` is computed and assigned back to `minSpaces`. The "+1" indicates the current valid number prefix, which requires one space.
	- The loop continues, trying all possible valid prefixes from the current index.
	- Finally, the `minSpaces` value is stored in the `cache` to avoid redundant calculations and returned as the result for the current `idx`.

	3. `min` function:
	- A simple utility function to return the minimum of two integers.

	The `NumbersInPi` function is the entry point, and the `getMinSpaces` function handles the recursive computation with memoization.
	By using memoization, the code optimizes and reduces redundant calculations, making it more efficient than a pure
	recursive solution. The result returned by `NumbersInPi` is the minimum number of spaces required to divide the pi string
	into valid numbers from the given list. If it is not possible to form valid numbers using the given list,
	the function returns -1.
*/
package main

import "math"

// NumbersInPi finds the minimum number of spaces needed to divide the pi string
// into valid numbers from the given list of numbers.
func NumbersInPi(pi string, numbers []string) int {
	numbersTable := map[string]bool{}
	for _, number := range numbers {
		numbersTable[number] = true
	}

	// Cache to store results of subproblems to avoid redundant calculations
	cache := map[int]int{}
	minSpaces := getMinSpaces(pi, numbersTable, cache, 0)

	if minSpaces == math.MaxInt32 {
		return -1
	}
	return minSpaces
}

// getMinSpaces calculates the minimum number of spaces needed to divide the remaining
// suffix of the pi string into valid numbers from the numbersTable.
func getMinSpaces(pi string, numbersTable map[string]bool, cache map[int]int, idx int) int {
	// Base case: If the end of the pi string is reached, return -1.
	// This indicates that the suffix of the pi string cannot be divided into valid numbers.
	if idx == len(pi) {
		return -1
	} else if val, found := cache[idx]; found {
		// If the result for the current index is already in the cache, return it.
		return val
	}

	minSpaces := math.MaxInt32
	// Iterate over possible prefixes starting from the current index.
	for i := idx; i < len(pi); i++ {
		prefix := pi[idx : i+1]

		// If the prefix is found in the numbersTable, it is a valid number prefix.
		if _, found := numbersTable[prefix]; found {
			// Recursively calculate the minimum number of spaces in the suffix.
			minSpacesInSuffix := getMinSpaces(pi, numbersTable, cache, i+1)
			// Update the minimum spaces with the current prefix if it leads to a valid number.
			minSpaces = min(minSpaces, minSpacesInSuffix+1)
		}
	}

	// Cache the result for the current index to avoid redundant calculations.
	cache[idx] = minSpaces
	return cache[idx]
}

// min returns the minimum of two integers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
