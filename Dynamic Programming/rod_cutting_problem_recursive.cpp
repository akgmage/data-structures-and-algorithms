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
// Recursive solution TC : O(2^n)
// Program Author: Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
int max_profit(vector<int> length, int n){
    if(n == 0) return 0;
    int best = 0;
    for(int i = 0; i < n; i++){
        int total_profit = length[i] + max_profit(length, n - (i + 1));
        best = max(best, total_profit);
    }
    return best;
}
int main(){
    int n;
    cin >> n;
    vector<int> length(n);
    for(int i = 0; i < n; i++)
        cin >> length[i];
    int result = max_profit(length, n);  
    cout << result;      
    return 0;
}
