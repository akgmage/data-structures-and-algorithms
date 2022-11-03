#include<bits/stdc++.h>
using namespace std;
int find_set_bits(int n){
    int set_bits = 0;
    while(n){
        set_bits += (n & 1);
        n >>= 1;
    }
    return set_bits;
}
int main(){
    cout << find_set_bits(4) << endl;
    return 0;
}
