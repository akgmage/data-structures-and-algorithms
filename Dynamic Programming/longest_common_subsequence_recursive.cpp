// Recursion : Find Longest Common Subsequence of two string
// Program Author : Abhisek Kumar Gupta
/*
    This problem exemplify optimal substructure property and the 
    bigger problem can be defined in terms of mini subprobs of same type 
    hence recursion
*/

#include<bits/stdc++.h>
using namespace std;
int get_max(int x, int y){
    return (x > y) ? x : y; 
}
int find_longest_common_subsequence(string a, string b, int n, int m){
    if(m == 0 || n == 0)
        return 0;
    // we start by comparing last two characters of strings and there are two
    // possibilities 
    // 1) both are same [means we already have found one character in LCS so 
    //    add 1 and make recursive call with modified strings]
    if(a[n - 1] == b[m - 1]){
        return 1 + find_longest_common_subsequence(a, b, n-1, m-1);
    }
    // 2) both are different [find length of tow lcs, first haveing n-1 character from first string
    //    and m characters from second string, and another with m characters from first string and 
    //    m - 1 characters from second string and return the max of two]
    else{
        return get_max(find_longest_common_subsequence(a, b, n-1,m),
                        find_longest_common_subsequence(a, b, n, m-1));
    }    
}
int main(){
    string a = "ABCEFIHST";
    string b = "DCEFKAAAQST";
    int n = a.length();
    int m = b.length();
    int result = find_longest_common_subsequence(a, b, n, m);
    cout << result;
}
// Code takes exponential time 2^n in the worst case i.e when all
// two characters are different
//                        ACB |  ABC
//            ACB | AB                   AC | ABC
//            AC  | A                    A  | AB
//        A | A       AC |          A | A        | AB
// BECAUSE WE ARE SOLVING ONE SUB PROBLEM MULTIPLE TIMES SO LCS PROBLEM 
// DEMONSTRATES OPTIMAL SUBSTRUCTURE PROPERTY AND THERE ARE OVERLAPPING
// SUBPROBLEMS TOO, SO WE WILL USE MEMOIZATION / DP TO SOLVE THIS PROBLEM 
// OPTIMALLY 