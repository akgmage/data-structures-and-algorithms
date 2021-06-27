#include<bits/stdc++.h>
using namespace std;
int fib(int n){
	if(n <= 1)
		return n;
	return fib(n-1) + fib(n-2);
}
int main(){
	int n;
	cout << "Give me n : ";
	cin >> n;
	int result = fib(n);
	cout << result << endl;
}
