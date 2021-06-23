#include<bits/stdc++.h>
using namespace std;
int modular_expo(int x, int n, int mod){
   int ans = 1;
   while(n >= 1){
       if(n % 2 == 0){
          x = ((x % mod) * (x % mod)) % mod;
          n /= 2;
       }
       else{
           ans = ((ans % mod) * (x % mod)) % mod;
           n--;
       }
   }
   return ans;
}
int main(){
	int mod = 1000000007;
    cout << modular_expo(5, 3, mod);
return 0;
}
