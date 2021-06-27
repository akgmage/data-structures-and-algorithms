#include<bits/stdc++.h>
using namespace std;
int count_zeros(int n){
    if(n == 0)
        return 0;       
    int small_no = count_zeros(n / 10);
    return small_no + 1;
}
int main(){
    cout << count_zeros(2003099910);
    return 0;
}