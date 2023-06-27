/*
	Coin Change Problem
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount
    of money.Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
    combination of the coins, return -1.You may assume that you have an infinite number of each kind of coin.

	This implementation uses a bottom-up approach to fill in a 2D table of minimum coin counts for each amount 
	up to the target amount. The table is initialized with the base cases (0 coins for an amount of 0, infinity 
	for an amount greater than 0) and then filled in using the recurrence relation:
	
	dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
	
	where dp[i][j] is the minimum number of coins needed to make an amount of j using the first i coins. 
	If the current coin value coins[i-1] is greater than the current amount j, then we can't use that coin, 
	so we take the minimum number of coins we need to make the amount using only the first i-1 coins (dp[i-1][j]). 
	Otherwise, we can use the current coin, so we take the minimum of the number of coins we need to make the 
	amount using only the first i-1 coins (dp[i-1][j]) and the number of coins we need to make the amount minus 
	the value of the current coin, plus one (dp[i][j-coins[i-1]]+1).

	The final result is dp[len(coins)][amount], which gives us the minimum number of coins needed to make the 
	target amount. If this value is infinity, then it's not possible to make the amount using the given coins, 
	so we return -1.

	Sample Input : [1, 2, 5] target : 11
	Output 3 (5, 5, 1)

	The time complexity of this implementation is O(nm), where n is the number of coins and m is the target amount. 
	The space complexity is also O(nm) because we're storing a 2D table of size (n+1) x (m+1).

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
