def maxProfit(prices):
    minElement = 10000
    maxDiff = 0
    for i in range(len(prices)):
        minElement = min(prices[i], minElement)
        maxDiff = max(prices[i]-minElement, maxDiff)
        
    return maxDiff

prices = [7,1,5,3,6,4]
print(maxProfit(prices))
