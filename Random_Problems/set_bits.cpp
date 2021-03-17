// Count the number of bits that are set in an integer
#include<bits/stdc++.h>
using namespace std;
short check_set_bits(unsigned int x){
    short num_bits = 0;
    while(x){
        num_bits += x & 1;
        x >>= 1;
    }
    return num_bits;
}
int main(){
    cout << check_set_bits(1) << endl;
    cout << check_set_bits(7) << endl;
    cout << check_set_bits(15) << endl;
    return 0;
}