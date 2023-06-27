/* 
    Coin Change Problem
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
    0 <= amount <= 104 */

//SOLUTION
//EXPLANATION OF CODE
/*Using unbounded knapsack in Dynamic programming 
 * The minimal number of coins required to make up a specific sum using a certain number of coins is stored in a 2D array.
 *  The array's dimensions are n+1 and amount+1, where n is the length of the coins array.
 * Initialisation 1
 * t[i][j] is set to Integer when i = 0.MAX_VALUE-1 indicates that the amount j cannot be calculated using 0 coins. For j = 0, 
 * t[i][j] is set to 0, suggesting that the amount 0 can be made up of any number of coins.
 * Initialisation 2
 * If the amount j is a multiple of the first coin denomination, then the minimum number of coins required to make up the amount j is j/coins[0]. 
 * Otherwise, it is not possible to make up the amount j using only the first coin denomination, so the value of t[1][j] is set to 
 * Integer.MAX_VALUE-1.
 * 
 * main code
 * The third loop fills in the t array for all other cases. If the current coin denomination coins[i-1] is less than or equal to the current amount
 *  j, then we can either include or exclude the current coin denomination to make up the amount j. If we include the current coin denomination, 
 * then the minimum number of coins required is 1 + t[i][j-coins[i-1]]. If we exclude the current coin denomination, then the minimum number of 
 * coins required is t[i-1][j]. We take the minimum of these two values to get the minimum number of coins required to make up the amount j using 
 * the first i coin denominations.
Finally, if the value of t[n][amount] is still Integer.MAX_VALUE-1, then it is not possible to make up the amount amount using the coin 
denominations in coins, so we return -1. Otherwise, we return the value of t[n][amount], which represents the minimum number of coins required to 
make up the amount amount using all the coin denominations in coins.
*/

//Code:
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        int t[][]= new int[n+1][amount+1];  
        for(int i=0; i<n+1; i++){                         //Initialisation 1 
            for(int j=0; j<amount+1;j++){
                if(i==0){
                    t[i][j]=Integer.MAX_VALUE-1;
                }
                if(j==0){
                    t[i][j]=0;
                }
                
            }
        }
        for(int j=1; j<amount+1; j++){                 //Initialisation 2
            if(j%coins[0]==0){
                t[1][j]=j/coins[0];
            }
            else{
                t[1][j]=Integer.MAX_VALUE-1; 
            }
        }
        for(int i=2; i<n+1; i++){                                  //Main code
            for(int j=1; j<amount+1;j++){
                if(coins[i-1]<=j){
                    t[i][j]=Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        if(t[n][amount]==Integer.MAX_VALUE-1){
            return -1;
        }
                return t[n][amount];       //answer
    }
}