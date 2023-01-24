function maxProfit(prices) {
    let maxProfit = 0;
    let minPrice = Infinity;
    for(let i = 0; i < prices.length; i++) {
        const currentPrice = prices[i];
        minPrice = Math.min(minPrice, currentPrice);
        maxProfit = Math.max(maxProfit, currentPrice - minPrice);
    }
    return maxProfit;
}

const prices = [7,1,5,3,6,4];

console.log(maxProfit(prices));

function maxProfit(prices) {
    let maxProfit = 0;
    for(let i = 0; i < prices.length; i++) {
        for(let j = i + 1; j < prices.length; j++) {
            const profit = prices[j] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }
    }
    return maxProfit;
 }