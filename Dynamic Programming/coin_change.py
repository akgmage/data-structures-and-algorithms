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
