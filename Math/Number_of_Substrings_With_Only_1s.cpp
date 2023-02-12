/*
Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.
Example 2:

Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s.
Example 3:

Input: s = "111111"
Output: 21
Explanation: Each substring contains only 1's characters.
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.

Approach: First we count continuos number of ones and if we have n continuos 1's than total substring = (n*(n+1))/2. Using this we can count all substring and add them and return.
using this property (a*b)%mod = ((a%mod)*(b%mod))%mod
*/
class Solution {
public:
    int mod = 1000000007;
    int numSub(string s) {
        long long cnt = 0,ans=0;
        for(int i = 0;i<s.size();i++){
            if(s[i]=='1'){
                cnt++;
            }else{
                ans = (ans+((cnt%mod)*(cnt+1)%mod)%mod/2)%mod;
                cnt=0;
            }
        }
        ans = (ans+((cnt%mod)*(cnt+1)%mod)/2)%mod;
        return (int)(ans);
    }
};
