// DP : Find Longest Common Subsequence of two string
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>

using namespace std;
const int maxi = 10000;
int find_longest_common_subsequence(string a, string b, int n, int m, int dp[][maxi]){
    for(int i = 0; i <= n; i++){
        dp[i][0] = 0;
    }
    for(int i = 0; i <= m; i++){
        dp[0][i] = 0;
    }    
    // dp solution builds the table of LCS of substrings and starts
    // computing the length building on the final solution
    // we place one string along row and one along the column
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            // populating table in row-wise order
            if(a[i - 1] == b[j - 1]){
                dp[i][j] = dp[i - 1][j - 1] + 1; 
            }
            else{
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n];
}
int main(){
    string a = "DABCEFIHKST";
    string b = "DCEFKAAAQST";
    int n = a.length();
    int m = b.length();
    int dp[n+1][maxi];
    memset(dp, -1, sizeof(dp));
    int result = find_longest_common_subsequence(a, b, n, m, dp);
    cout << result;
    return 0;
}
// Time complexity O(N * M)  improvement over both 
// Recursion and memoization
// Space complexity O(N * M)