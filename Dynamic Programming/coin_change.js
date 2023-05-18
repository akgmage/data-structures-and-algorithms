/*
    Coin Change Problem:-


    Question:-
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount
    of money.Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
    combination of the coins, return -1.You may assume that you have an infinite number of each kind of coin.

    Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Example 2:
    Input: coins = [2], amount = 3
    Output: -1

    Example 3:
    Input: coins = [1], amount = 0
    Output: 0
    
    Constraints:
    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104


    Approach Explanation:-

    The code uses a dynamic programming approach to solve the coin change problem. The dp array is used to 
    store the minimum number of coins needed to make each amount from 0 to amount. The minimum number 
    of coins needed to make an amount of 0 is 0. Then, for each coin, the code iterates through each 
    amount from the coin value to the target amount. If the current amount minus the coin value is a 
    valid amount, the code updates the minimum number of coins needed to make that amount by taking 
    the minimum of the current value and the value of dp[i - coin] + 1. Finally, if the minimum 
    number of coins needed to make the target amount is still Infinity, it is not possible to make 
    the amount and the code returns -1. Otherwise, the code returns the minimum number of coins 
    needed to make the target amount.

    The time complexity is O(n * V), where n is the number of coins and V is the value we want to make change for. 
    The space complexity is also O(n * V) as we need to store the minimum number of coins required to make 
    change for every value up to V for every coin.

    In the worst case, when we have a large number of coins and a large value V, the time and space complexity 
    can become quite large. However, this approach can efficiently handle a wide range of input values and is 
    guaranteed to give the optimal solution.
*/

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */


var coinChange = function(coins, amount) {

    // Create a array to store the minimum number of coins needed to make each amount from 0 to amount
    const dp=Array(amount+1).fill(Infinity);

    // The minimum number of coins needed to make an amount of 0 is 0
    dp[0]=0;

    // Iterate through each coin
    for(const coin of coins){
        // Iterate through each amount from the coin value to the target amount
        for(let i=coin;i<=amount;i++){
            // If the current amount minus the coin value is a valid amount, update the minimum number of coins needed
            if(dp[i-coin]!=Infinity)
            {
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
    }

    // If the minimum number of coins needed to make the target amount is still Infinity, it is not possible to make the amount
    if(dp[amount]===Infinity)
    {
        return -1;
    }

    // Return the minimum number of coins needed to make the target amount
    return dp[amount];
};
