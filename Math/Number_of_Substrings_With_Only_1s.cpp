/*
first we count continuos number of ones and if we have n continuos 1's than total substring = (n*(n+1))/2. Using this we can count all substring and add them and return.
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
