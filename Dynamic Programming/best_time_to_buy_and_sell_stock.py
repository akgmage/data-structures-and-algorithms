# Best Time to buy and sell stock
'''
    The function maxProfit takes a list of integers prices and returns the maximum profit that can be 
    made from buying and selling the stock represented by prices. The function works by initializing 
    the minimum price to a very large number (sys.maxsize) and the maximum profit to 0.

    It then loops through the prices, updating the minimum price if the current price is less than the current minimum 
    price, and updating the maximum profit if the difference between the current price and the minimum 
    price is greater than the current maximum profit. Finally, it returns the maximum profit.

    
    Sample Input [7, 1, 5, 3, 6, 4]  
    Output: 5 buy at 1 sell at 6

    Time Complexity: O(n), where n is the length of the prices array.
	Space Complexity: O(1), as we are only using two variables to keep track of the minimum price and maximum profit
'''


def maxProfit(prices: List[int]) -> int:
    # initialize the minimum price as maximum integer value
    min_price = sys.maxsize
    
    # initialize the maximum profit as 0
    max_profit = 0
    
    # loop through the prices
    for price in prices:
        # if the current price is less than the minimum price, update the minimum price
        if price < min_price:
            min_price = price
        # else if the difference between the current price and the minimum price is greater than the maximum profit,
        # update the maximum profit
        elif price - min_price > max_profit:
            max_profit = price - min_price
    
    # return the maximum profit
    return max_profit

prices = [7, 1, 5, 3, 6, 4]
profit = maxProfit(prices)
print(profit)  # Output: 5