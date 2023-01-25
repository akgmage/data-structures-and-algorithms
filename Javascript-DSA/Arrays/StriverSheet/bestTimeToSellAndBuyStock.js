// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// O(n) time | O(1) space
var maxProfit = function(prices) {
    let maximumProfit = 0;
    let minimumStockPrice = Infinity;
    
    for(let i = 0; i < prices.length; i++) {
        const currentPrice = prices[i];
        minimumStockPrice = Math.min(minimumStockPrice, currentPrice);
        maximumProfit = Math.max(maximumProfit, currentPrice - minimumStockPrice);
    }
    return maximumProfit;
};

console.log(maxProfit([7,1,5,3,6,4]));