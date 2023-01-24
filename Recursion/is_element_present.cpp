// Program to check if an element is present in an array
// Sample Input: [1, 2, 3, 4, 4, 5, 3] key: 51
// Output: 0 meaning false
// Sample Input: [1, 2, 3, 4, 4, 5, 3] key: 5
// Output: 1 meaning true
#include<bits/stdc++.h>
using namespace std;
bool is_element_present(int A[], int m, int key){
    if(m == 0)
        return false;
    if(A[0] == key)
        return true;    
    return is_element_present(A + 1, m - 1, key);        
}
bool is_element_present2(int A[], int m, int key, int i){
    if(i == m)
        return false;
    if(A[i] == key)
        return true;    
    return is_element_present2(A, m, key, i + 1);        
}
int main(){
    int A[7] = {1, 2, 3, 4, 4, 5, 3};
    int key = 51;
    cout << is_element_present(A, 7, key) << endl;
    cout << is_element_present2(A, 7, 5, 0) << endl;
    return 0;
}