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
