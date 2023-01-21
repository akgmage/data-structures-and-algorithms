// Count the number of 0's in an integer
// Sample Input : 10010
// Output: 3
#include<bits/stdc++.h>
using namespace std;
int count_zeros(int n){
    if(n == 0)
        return 0;
    // divide the number recursively and hit the base case    
    int small_no = count_zeros(n / 10);
    int last_digit = n % 10;
    if(last_digit == 0)
        return small_no + 1;
    else 
        return small_no;    
}
int main(){
    cout << count_zeros(2003010);
    return 0;
}