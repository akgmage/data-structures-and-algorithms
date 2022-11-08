// Factorial of an integer
// Sample Input: 5
// Output: 120
#include<iostream>
using namespace std;
int factorial(int n){
	cout << "I am calculating f(" << n << ")\n";	
	if(n == 0)
		return 1;
	int f =  n * factorial(n - 1);
	cout << "Done! f(" << n << ") = " << f << endl; 
	return f;
}
int main(){
	int n;
	cout << "Give me n : ";
	cin >> n;
	int result = factorial(n);
	cout << result << endl;	
	return 0;
}
