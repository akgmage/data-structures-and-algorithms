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
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let minPrice = Infinity; // keep track of minimum price seen so far
  let maxProfit = 0; // keep track of maximum profit seen so far

  for (let i = 0; i < prices.length; i++) {
    if (prices[i] < minPrice) {
      minPrice = prices[i]; // update minimum price seen so far
    } else if (prices[i] - minPrice > maxProfit) {
      maxProfit = prices[i] - minPrice; // update maximum profit seen so far
    }
  }

  return maxProfit;
};

const prices = [7, 1, 5, 3, 6, 4];
console.log(maxProfit(prices)); // Output: 5
