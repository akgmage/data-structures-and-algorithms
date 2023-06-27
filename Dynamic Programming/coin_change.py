'''
    Coin Change Problem
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount
    of money.Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
    combination of the coins, return -1.You may assume that you have an infinite number of each kind of coin.

    The coin change problem is a dynamic programming solution that takes a list of coin denominations and a 
    target value as inputs, and returns the minimum number of coins required to reach the target value. 
    It uses a bottom-up approach to build a table of minimum coin counts for each target value up to the 
    input target. 

    Sample Input : [1, 2, 5] target : 11
	Output 3 (5, 5, 1)
    
    The time complexity of this implementation is O(amount * n), where n is the number of coins. 
    The space complexity is O(amount).

    Note that this implementation assumes that there are infinite coins of each denomination. 
    If the number of coins is limited, then the implementation can be modified to keep track of the number of coins used as well.
'''
def coin_change(coins, amount):
    # Initialize the DP table with float('inf') values for all amounts
    dp = [float('inf') for _ in range(amount+1)]
    # DP value for 0 amount is always 0
    dp[0] = 0
    
    # Iterate through each coin denomination
    for coin in coins:
        # Update DP values for all amounts that can be obtained using the current coin
        for i in range(coin, amount+1):
            # Choose the minimum between the current DP value and the DP value obtained
            # by subtracting the current coin from the current amount and adding 1 to it
            dp[i] = min(dp[i], dp[i-coin]+1)
    
    # If the DP value for the target amount is still float('inf'), then it's not possible to make change
    if dp[amount] == float('inf'):
        return -1
    else:
        return dp[amount]
