// Canculate power of x^n
// Sample Input : 3 2
// Output : 9

#include<bits/stdc++.h>
using namespace std;

// Method 1 Time complexity O(n)
int power1(int x, int n){
	if(n == 0)
		return 1;
	return x * power1(x, n-1);
}

// Method 2 : Time complexity O(log n)
int power(int x, int n){
	if(n == 0)
		return 1;
	else if(n % 2 == 0){
		int y = power(x, n / 2);
		return y * y;	
	}
	return x * power(x, n - 1);
}

int main(){
	int x, n;
	cout << "Give me x annd n";
	cin >> x >> n;
	int result = power(x,n);
	cout << result << endl;
	return 0;
}
