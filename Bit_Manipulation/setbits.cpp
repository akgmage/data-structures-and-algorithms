#include<bits/stdc++.H>
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
    cout << find_set_bits(5) << endl;
    cout << find_set_bits(6) << endl;
    cout << find_set_bits(7) << endl;
    cout << find_set_bits(15) << endl;
    return 0;
}
