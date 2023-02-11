/*
    Given n wines in a row, with integers denoting the cost of each wine respectively. 
    Each year you can sale the first or the last wine in the row. However, the price 
    of wines increases over time. Let the initial profits from the wines be P1, P2, P3…Pn. 
    On the Yth year, the profit from the ith wine will be Y*Pi.
    Calculate the maximum profit from all the wines.

    Input  : 5
           : 2 4 6 2 5
    Output : 64 
*/
// Dynamic Programming Approach TC : O(N^2)
// Program Author :  Abhisek Kumar Gupta

#include<bits/stdc++.h>
using namespace std;
int find_max_profit(int *A, int n){
    int dp[100][100] = {};
    int year = n;
    for(int i = 0; i < n; i++){
        dp[i][i] = year * A[i];
    }
    year--;
    for(int i = 2; i <= n; i++){
        int start = 0;
        int end = n - i;
        while(start <= end){
            int end_window = start + i - 1;
            int x = A[start] * year + dp[start + 1][end_window];
            int y = A[end_window]* year + dp[start][end_window - 1];
            dp[start][end_window] = max(x, y);
            start++;
        }
        year--;
    }
  /*  for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout << setw(5) << dp[i][j] << " ";
        }
        cout << "\n";
    }
  */  
    return dp[0][n-1];
}
int main(){
    int n;
    cin >> n;
    int *A;
    for(int i = 0; i < n; i++)
        cin >> A[i];
    int start = 0;
    int end = n - 1; 
    int year = 1;   
    int result = find_max_profit(A, n);    
    cout << result;
    return 0;
}
