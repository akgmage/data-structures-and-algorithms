#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int coinChange(vector<int>& coins, int amount) {
    // Create a vector to store the minimum number of coins needed to make each amount from 0 to amount
    vector<int> dp(amount + 1, INT_MAX);
    
    // The minimum number of coins needed to make an amount of 0 is 0
    dp[0] = 0;
    
    // Iterate through each coin
    for (int coin : coins) {
        // Iterate through each amount from the coin value to the target amount
        for (int i = coin; i <= amount; i++) {
            // If the current amount minus the coin value is a valid amount, update the minimum number of coins needed
            if (dp[i - coin] != INT_MAX) {
                dp[i] = min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    
    // If the minimum number of coins needed to make the target amount is still INT_MAX, it is not possible to make the amount
    if (dp[amount] == INT_MAX) {
        return -1;
    }
    
    // Return the minimum number of coins needed to make the target amount
    return dp[amount];
}

int main() {
    vector<int> coins = {1, 2, 5};
    int amount = 11;
    cout << "Minimum number of coins needed: " << coinChange(coins, amount) << endl;
    return 0;
}
