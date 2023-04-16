package main

import (
	"fmt"
	"math"
)

func maxProfit(prices []int) int {
	minPrice := math.MaxInt32 // Initialize minimum price to maximum integer value
	maxProfit := 0            // Initialize maximum profit to 0
	for _, price := range prices {
		if price < minPrice {
			minPrice = price // Update minimum price
		} else if price-minPrice > maxProfit {
			maxProfit = price - minPrice // Update maximum profit
		}
	}
	return maxProfit // Return maximum profit
}

func main() {
	prices := []int{7, 1, 5, 3, 6, 4}
	fmt.Println(maxProfit(prices)) // Output: 5
}