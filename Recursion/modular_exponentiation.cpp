// Modular exponentiation is exponentiation performed over a modulus. 
// It is useful in computer science, especially in the field of public-key cryptography, 
// where it is used in both Diffie-Hellman Key Exchange and RSA public/private keys.

// Sample Input : 2 3 100
// Output: 8

#include<bits/stdc++.h>
using namespace std;
int mod(int x, int n, int m){
	if(n == 0)
		return 1;
	else if( n % 2 == 0){
		int y = mod(x, n/2, m);
		return y * y % m;		
	}
	return ((x % m) * mod(x, n-1, m)) % m;
}
int main(){
	int x, n, m;
	cout << "Give me x, n and m : ";
	cin >> x >> n >> m;
	int result = mod(x, n, m);
	cout << result << endl;
	return 0;
}
