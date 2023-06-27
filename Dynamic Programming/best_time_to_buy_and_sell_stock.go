// Best Time to buy and sell stock
/*
	Explanation:
	We start by initializing the minimum price to the maximum integer value and the maximum profit to 0.
	We loop through the prices array, and for each price:
	If the price is less than the current minimum price, we update the minimum price.
	Otherwise, if the difference between the price and the minimum price is greater than the current maximum profit, we update the maximum profit.
	Finally, we return the maximum profit
	
	Sample Input [7, 1, 5, 3, 6, 4]
	Output: 5 buy at 1 sell at 6
	
	Time Complexity: O(n), where n is the length of the prices array.
	Space Complexity: O(1), as we are only using two variables to keep track of the minimum price and maximum profit
*/
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