// Program to count the number of bits that are set to 1 in an integer
// The following program tests bits one at a time starting with the least-significant bit.
// Since we perform O(1) computation per bit, the time complexity is O(n) where n is number of bits in the integer
// Best case time complexity is O(1), if the input io 0
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
