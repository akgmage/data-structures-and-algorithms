// Count the number of digits in an integer
// Sample Input: 2003
// Output: 4

#include<bits/stdc++.h>
using namespace std;
int count_digits(int n){
    if(n == 0)
        return 0;       
    int small_no = count_digits(n / 10);
    return small_no + 1;
}
int main(){
    cout << count_digits(2003099910);
    return 0;
}