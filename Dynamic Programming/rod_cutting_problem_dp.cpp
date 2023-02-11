 /*
    Given a rod of length n inches and an array of prices that contains prices of all 
    pieces of size smaller than n. Determine the maximum value obtainable by cutting 
    up the rod and selling the pieces. For example, if length of the rod is 8 and the 
    values of different pieces are given as following, then the maximum obtainable 
    value is 22 (by cutting in two pieces of lengths 2 and 6) 
    Input  : 8 
           : 1   5   8   9  10  17  17  20
    Output : 22     
*/
// Dynamic Programming solution TC : O(n^2)
// Program Author: Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
int max_profit(vector<int> profit, int total_length){
    int dp[100] = {};
    for(int length = 1; length <= total_length; length++){
        int best = 0;
        for(int cut = 1; cut <= length; cut++){
            best = max(best, profit[cut] + dp[length - cut]);
        }
        dp[length] = best;
    }
    return dp[total_length];    
}
int main(){
    int total_length;
    cin >> total_length;
    vector<int> profit(total_length + 1);
    for(int length = 1; length <= total_length; length++)
        cin >> profit[length];
    int result = max_profit(profit, total_length);  
    cout << result;      
    return 0;
}