#include<bits/stdc++.h>
using namespace std;

int f[100], expo[100], len = -1;

int main(){
	int n;
    cin >> n;
    int d = 2;
    while(n > 1 && d * d <= n){
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
    for(int i = 0; i <= len; i++){
        cout << f[i] << "->" << expo[i] << " Times" << endl;
    }
	
return 0;
}
