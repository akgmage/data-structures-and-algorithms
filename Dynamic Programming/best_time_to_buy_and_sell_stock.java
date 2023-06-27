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
public class Solution {
    public int maxProfit(int[] prices) {
        // Initialize variables to track the minimum price seen so far and the maximum profit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Loop through the prices array
        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than the minimum price seen so far, update the minimum price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // If the difference between the current price and the minimum price is greater than the maximum profit seen so far, update the maximum profit
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit; // Return the maximum profit
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}

