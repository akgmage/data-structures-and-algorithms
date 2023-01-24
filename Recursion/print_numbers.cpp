// Print numbers recursively
// Sample Input: 5
// Output: 1 2 3 4 5
#include<bits/stdc++.h>
using namespace std;
void print(int n){
    if(n == 0)
        return;
    print(n - 1);
    cout << n << " ";    
}
int main(){
    print(5);
    return 0;
}