// Prime factorisation is a method to find the prime factors of a given number, say a composite number. 
// These factors are nothing but the prime numbers. A prime number is a number 
// which has only two factors, i.e. 1 and the number itself. For example, 2 is a prime number which has two factors, 2 × 1
// Sample Input: 10
// Output 
// 2->1 Times
// 5->1 Times
#include<bits/stdc++.h>
using namespace std;

int f[100], expo[100], len = -1;
void prime_factor(int n){
    int d = 2;
    if(n == 1){
        len++;
        f[len] = 2;
        expo[len] = 0;
        return;
    }
    while(n > 1 && 1ll * d * d <= n){
        int k = 0;
        while(n % d == 0){
            n = n / d;
            k++;
        }
        if(k > 0){
            len++;
            f[len] = d;
            expo[len] = k;
        }
        d++;
    }
    if(n > 1){
        len++;
        f[len] = n;
        expo[len] = 1;
    }
}
int main(){
	int n;
    cin >> n;
    prime_factor(n);
    for(int i = 0; i <= len; i++){
        cout << f[i] << "->" << expo[i] << " Times" << endl;
    }
	
return 0;
}
