/*
	Given an array of distinct positive integers representing coin denominations and a single non-negative integer n
	representing a target amount of money, write a function that returns the number of ways to make change for
	that target amount using the given coin denominations.

	Sample Input: n = 6 denominations : [1, 5]
	Output: 2 (1 * 1 + 1 * 5 and  6 * 1)
*/
package main

func NumberOfWaysToMakeChange(n int, denoms []int) int {
	// Create an array to store the number of ways to make change for each amount from 0 to n.
	ways := make([]int, n+1)

	// Initialize the base case: There is one way to make change for amount 0 (using no coins).
	ways[0] = 1

	// Iterate over each denomination.
	for _, denom := range denoms {
		// For each denomination, iterate over each amount from 1 to n.
		for amount := 1; amount < n+1; amount++ {
			// Check if the denomination can be used to make change for the current amount.
			if denom <= amount {
				// Add the number of ways to make change for the current amount
				// by considering the current denomination.
				ways[amount] += ways[amount-denom]
			}
		}
	}

	// Return the number of ways to make change for the target amount n.
	return ways[n]
}
