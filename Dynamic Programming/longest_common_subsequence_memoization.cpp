// Memoization : Find Longest Common Subsequence of two string
// Program Author : Abhisek Kumar Gupta
/*
    To avoid computation of subproblem many times we use memoization
    here we take 2D array of size n*m memoization[n][m]
    when length of lcs of first i characters of a and j characters of b is 
    computed for first time it is stored in cell memoization[i][j]
    if function is called with n = i and m = j then LCS is not computed from scratch
    and stored value is returned from table
*/
#include<bits/stdc++.h>
using namespace std;
const int maxi = 10000;
int get_max(int x, int y){
    return (x > y) ? x : y; 
}
int find_longest_common_subsequence(string a, string b, int n, int m, int memoization[][maxi]){
    if(m == 0 || n == 0)
        return 0;
    // if value is already computed then return the value    
    if(memoization[n][m] != -1){
        return memoization[n][m];
    }    
    if(a[n - 1] == b[m - 1]){
        // memoize the solution in order to avoid recomputation
        memoization[n][m] =  1 + find_longest_common_subsequence(a, b, n - 1, m - 1, memoization);
    }
    else{
        // memoize the solution in order to avoid recomputation
        memoization[n][m] = get_max(find_longest_common_subsequence(a, b, n - 1, m, memoization),
                                    find_longest_common_subsequence(a, b, n, m -1, memoization));
    }
    return memoization[n][m];    
}
int main(){
    string a = "DABCEFIHKST";
    string b = "DCEFKAAAQST";
    int n = a.length();
    int m = b.length();
    int memoization[n+1][maxi];
    memset(memoization, -1, sizeof(memoization));
    int result = find_longest_common_subsequence(a, b, n, m, memoization);
    cout << result;
    return 0;
}
// Time complexity from exponential to polynomial O(N * M) 
// Space complexity O(N * M)