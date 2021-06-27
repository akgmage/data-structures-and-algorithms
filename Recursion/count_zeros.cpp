#include<bits/stdc++.h>
using namespace std;
int count_zeros(int n){
    if(n == 0)
        return 0;
        
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