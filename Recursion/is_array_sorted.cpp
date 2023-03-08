// Given an array, check whether the array is in sorted order with recursion.
// Sample Input: [1, 2, 3, 4, 4, 5, 3]
// Output: 0 meaning false
// Sample Output: [1, 2, 3, 4, 4, 5, 6]
// Output: 1 meaning true
#include<bits/stdc++.h>
using namespace std;
bool is_sorted(int A[], int m){
    if(m == 0 || m == 1)
        return true;       
    if(A[0] > A[1])
        return false;
    bool small_array = is_sorted(A + 1, m - 1);
    return small_array;        
}
int main(){
    int A[7] = {1, 2, 3, 4, 4, 5, 3};
    cout << is_sorted(A, 7);
    return 0;
}