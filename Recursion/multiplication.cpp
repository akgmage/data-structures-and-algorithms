// Multiply number using recursion
// Sample Input: 7, 9
// Output: 63
#include<bits/stdc++.h>
using namespace std;
int multiply(int n, int m){
    if(m == 0)
        return 0;       
    int small_m = multiply(n, m-1);
    return n + small_m;    
}
int main(){
    cout << multiply(7, 9);
    return 0;
}