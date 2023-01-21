/*
	Implelement memoized fibonacci

	Memoization is an enhancement procedure used to speed up computer programs by keeping the values
	of distinct function calls and returning the stored input when the same function is invoked again.

	Sample Input: 6
	Output: 8
*/
#include<bits/stdc++.h>
using namespace std;
int F[51];
int fib(int n){
	if(F[n] != -1)
		return F[n];
	F[n] = fib(n - 1) + fib(n-2);	
	return F[n];
}
int main(){	
	for(int i = 0; i < 51; i++)
		F[i] = -1;
	F[0] = 0;
	F[1] = 1;	
	int n;
	cout << "Give me n : ";
	cin >> n;
	int result = fib(n);
	cout << result;
return 0;
}
