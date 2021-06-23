#include<bits/stdc++.h>
using namespace std;
const int nmax = 100001;
bool is_prime[nmax];
void seive_of_ero(int n){
    for(int i = 2; i <= n; i++){
        is_prime[i] = true;
    }
    for(int i = 2; i <= n / 2; i++){
        if(is_prime[i]){
            for(int j = i * 2; j <= n; j += i){
                is_prime[j] = false;
            }
        }
    }
}
int main(){
	int n;
    cin >> n;
    seive_of_ero(n);
    for(int i = 0; i <= 500; i++){
        if(is_prime[i])
        cout << i << " " << endl;
    }
	
return 0;
}
