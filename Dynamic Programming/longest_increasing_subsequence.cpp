/*
    Longest Increasing Subsequence 
    Input : 1 2 1 3 1 4
    Output : 4
*/
// Dynamic Programming Approach : TC O(n^2)
// Program Author :  Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;

int find_longest_increasing_subsequence(vector<int> V, int n){
    int dp[n];
    int best = INT_MIN;
    for(int i=n-1;i>=0;i--)
    {
         int maxx =0;
          if(i==n-1)
          {
              dp[i]=1;
              best= max(best,dp[i]);
              continue;
           }
       for(int j=i+1;j<n;j++)
       {  
         if(V[i]<V[j])
         { 
          
             maxx= max(maxx,dp[j]);
           }
       }
        dp[i]= 1+maxx;
        best= max(best,dp[i]);
     }

    return best;
}
int main(){
    int n;
    cout << "Enter a number";
    cin >> n;
    vector<int> V(n);
    for(int i = 0; i < n; i++){
        cin >> V[i];
    }
    int result = find_longest_increasing_subsequence(V, n);
    cout << result;
}
