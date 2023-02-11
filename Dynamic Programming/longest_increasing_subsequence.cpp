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
    int dp[1004];
    for(int i = 0; i < 1000; i++) dp[i] = 1;
    int best = INT_MIN;
    for(int i = 1; i < n; i++){
        for(int j = 0; j < i; j++){
            if(V[j] <= V[i]){ // this means its in increasing order and we can take value stored at dp[j] and add 1 to it
                int curr_len = 1 + dp[j];
                dp[i] = max(curr_len, dp[i]);
            }
        }
        best = max(dp[i], best);
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
