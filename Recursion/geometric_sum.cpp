#include<bits/stdc++.h>
using namespace std;
double g_sum(int m){
    if(m == 0)
        return 1;       
    double small_num = g_sum(m - 1);
    return small_num + 1.0 / pow(2, m);
}    
int main(){
    cout << g_sum(2);
    return 0;
}