// Recursive Bubble sort
// Program Author : Abhisek Kumar Gupta
#include<bits/stdc++.h>
using namespace std;
void bubble_sort(int *A, int len){
    if(len == 1)
        return;
    for(int i = 0; i < len - 1; i++){
        if(A[i] > A[i+1]){
            swap(A[i], A[i+1]);
        }
    }
    bubble_sort(A, len-1);
}
int main(){
    int A[] = {5, 4, 3, 2, 1, 7};
    int len = sizeof(A) / sizeof(int);
    bubble_sort(A, len);
    for(int x : A){
        cout << x << " ";
    }
    return 0;
}