package main

import (
	"sort"
)


func NonConstructibleChange(coins []int) int {
	// Write your code here.
	result := 0
	sort.Ints(coins)

	for i := 0; i < len(coins); i++ {
		nextGreaterCoin := result + 1
		if coins[i] > nextGreaterCoin {
			return nextGreaterCoin
		} else if coins[i] <= nextGreaterCoin {
			result += coins[i]
		}
	}
   return result + 1
}


