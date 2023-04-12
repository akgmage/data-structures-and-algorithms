/*
	The coin change problem is a classic algorithmic problem, where given a target amount and a set of coin
	denominations, we need to find the minimum number of coins required to make up that amount.

	In this implementation, we start by sorting the array of coin denominations in descending order.
	We then iterate through the array from largest to smallest denomination, and for each denomination,
	we repeatedly subtract the largest possible multiple of that denomination from the target amount
	until we reach 0.

	The time complexity of this algorithm is O(n log n) due to the sorting step, where n is the number
	of coin denominations. However, the space complexity is O(1) since we are only using a constant
	amount of extra space.

	For the sample input coins := []int{1, 5, 10, 25} and target := 36, the output should be Minimum
	number of coins required to make 36 cents: 3.
*/
package main

import "fmt"

func coinChangeGreedy(coins []int, target int) int {
    count := 0
    for i := len(coins) - 1; i >= 0; i-- {
        for target >= coins[i] {
            target -= coins[i]
            count++
        }
    }
    return count
}

func main() {
    coins := []int{1, 5, 10, 25}
    target := 36
    result := coinChangeGreedy(coins, target)
    fmt.Printf("Minimum number of coins required to make %d cents: %d\n", target, result)
}
