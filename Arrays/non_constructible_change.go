/*
  Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you

  For example, if you're given coins = [1, 2, 5] , the minimum
  amount of change that you can't create is 4, . If you're given no
  coins, the minimum amount of change that you can't create is 1
*/
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