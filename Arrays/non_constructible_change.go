package main

import (
	"fmt"
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


func main() {
	coins := []int{1, 5, 1, 1, 1, 10, 15, 20, 100}

	msg := NonConstructibleChange(coins)
	fmt.Println(msg)
}