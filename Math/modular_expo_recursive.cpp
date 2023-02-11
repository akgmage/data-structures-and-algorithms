// Modular exponentiation is exponentiation performed over a modulus. 
// It is useful in computer science, especially in the field of public-key cryptography, 
// where it is used in both Diffie-Hellman Key Exchange and RSA public/private keys.
// Sample Input : 10 3
// Output : 1000
// recursive approach
#include<bits/stdc++.h>
using namespace std;
int modular_expo(int x, int n, int mod){
    if(n == 0)
        return 1;
    else if(n % 2 == 0){
        int y = modular_expo(x, n / 2, mod);
        return (y * y) % mod;
    }
    else{
        return ((x % mod) * modular_expo(x, n - 1, mod)) % mod;
    }    
}
int main(){
	int n, x, mod = 1000000007;
    cin >> x >> n;
    cout << modular_expo(x, n, mod);
return 0;
}
