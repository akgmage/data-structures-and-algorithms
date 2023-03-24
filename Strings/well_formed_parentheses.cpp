/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    
    Example 2:
    Input: n = 1
    Output: ["()"]
    
    Constraints: 1 <= n <= 8
*/ 
#include<bits/stdc++.h>
class Solution {
public:
vector<string> ans;
int N;
    void solve(string s,int count)
    {
        if(s.size()==2*N)
        ans.push_back(s);

        if(count<N)
        solve(s.push_back('('),count+1);
        else
        solve(s.push_back(')'),count);
    }
    vector<string> generateParenthesis(int n) {
        string st;
        solve(st,0);
        return ans;
    }
};