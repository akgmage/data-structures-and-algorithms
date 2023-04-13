/*
	This implementation uses a bottom-up approach to fill in a 2D table of minimum coin counts for each amount 
	up to the target amount. The table is initialized with the base cases (0 coins for an amount of 0, infinity 
	for an amount greater than 0) and then filled in using the recurrence relation:
	dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)

*/
package main

import (
	"fmt"
	"math"
)

func coinChange(coins []int, amount int) int {
	// create a 2D slice to store the minimum number of coins needed for each subproblem
	dp := make([][]int, len(coins)+1)
	for i := range dp {
		dp[i] = make([]int, amount+1)
	}

	// initialize the first row to infinity and the first column to 0
	for j := 1; j <= amount; j++ {
		dp[0][j] = math.MaxInt32
	}
	for i := 0; i <= len(coins); i++ {
		dp[i][0] = 0
	}

	// fill in the rest of the table
	for i := 1; i <= len(coins); i++ {
		for j := 1; j <= amount; j++ {
			if j < coins[i-1] {
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
			}
		}
	}

	// return the result
	if dp[len(coins)][amount] == math.MaxInt32 {
		return -1
	}
	return dp[len(coins)][amount]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	coins := []int{1, 2, 5}
	amount := 11
	fmt.Println(coinChange(coins, amount))
}
