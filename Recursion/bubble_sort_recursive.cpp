// Implementation of Recursive Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

// Time Complexity worst-case and average complexity O(n^{2})
// Bubble sort is O(n) on a list that is already sorted i.e. Best case

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
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