/*
      Program author: Varun Garg
*/

#include <bits/stdc++.h>
using namespace std;

int lcs(string s1,string s2){
      int n=s1.size(),m=s2.size();
      vector<vector<int>> dp(n+1,vector<int>(m+1,-1));

      // bottom up approach to calculate lcs
      // base conditions
      for(int i=0;i<=n;i++){
            dp[i][0]=0;
      }

      for(int i=0;i<=m;i++){
            dp[0][i]=0;
      }

      // filling the table to calculate the longest common subsequence 
      for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                  if(s1[i-1]==s2[j-1]){ // checking if the characters at both the string are same 
                        dp[i][j]=1+dp[i-1][j-1];  
                  }
                  else{
                        dp[i][j]=0+max(dp[i-1][j],dp[i][j-1]);
                  }
            }
      }

      return dp[n][m];
}

int main(){
      string s;
      cin>>s;
      string reverse_s;
      for(int i=s.size()-1;i>=0;i--){
            reverse_s.push_back(s[i]);
      }
      // the minimum steps to make a string pallindrome will require to calculate the 
      // longest common subsequence in the given string and the reverse of the string
      int ans=lcs(s,reverse_s);
      ans=s.size()-ans;
      cout<<ans;
}