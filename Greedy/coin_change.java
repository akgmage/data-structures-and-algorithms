package Greedy;

 /*
 * write a code in java with comments foor As a first example, 
 * we consider a problem where we are given a set of coins and our task is to 
 * form a sum of money n using the coins. The values of the coins are coins = {c1, c2,..., ck}, 
 * and each coin can be used as many times we want. What is the minimum number of coins needed? 
 * For example, if the coins are the euro coins (in cents) {1,2,5,10,20,50,100,200} and n = 520,
 *  we need at least four coins. The optimal solution is to select coins 200 + 200 + 100 + 20 whose sum is 520
 */
import java.util.Arrays;

public class CoinChange {

    /**
     * This method finds the minimum number of coins required to make change for a given amount of money using a given set of coins.
     *
     *  coins The set of coins that can be used to make change.
     *  n The amount of money to make change for.
     * @return The minimum number of coins required to make change for n.
     */
    public static int minCoins(int[] coins, int n) {
        // Create an array to store the minimum number of coins required to make change for each amount of money.
        int[] dp = new int[n + 1];

        // Initialize the array to Integer.MAX_VALUE. This means that we do not know the minimum number of coins required to make change for any amount of money yet.
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Set the minimum number of coins required to make change for 0 to 0.
        dp[0] = 0;

        // Iterate over the coins array.
        for (int i = 0; i < coins.length; i++) {
            // Iterate over the dp array.
            for (int j = coins[i]; j <= n; j++) {
                // Update the dp[j] element to be the minimum of dp[j] and dp[j - coins[i]] + 1.
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        // Return the minimum number of coins required to make change for n.
        return dp[n];
    }

    public static void main(String[] args) {
        // Create a set of coins.
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

        // The amount of money to make change for.
        int n = 520;

        // Find the minimum number of coins required to make change for n.
        int minCoins = minCoins(coins, n);

        // Print the minimum number of coins.
        System.out.println("The minimum number of coins required to make change for " + n + " cents is " + minCoins);
    }
}

// The minimum number of coins required to make change for 520 cents is 4
