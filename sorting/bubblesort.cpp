// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted.

// Time Complexity O(n2)

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
#include<bits/stdc++.h>
using namespace std;

void BubbleSort(int A[], int n){
	int flag = 0;
	for(int i = 0; i < n - 1; i++){
		for(int j = 0; j < n - i; j++){
			if(A[j] > A[j+1]){
				int temp = A[j];
				A[j] = A[j+1];
				A[j+1] = temp;
				flag = 1; //  // hack if the array is already sorted, no need for redundant passes
			}	 
		}
		if(flag == 0){ cout << "Already sorted so no further redundant passes best case O(n)"; break;}
	}
}
int main(){
	int A[] = {5,1,2,3,4,5};
	BubbleSort(A,6);
	for(int i = 0; i < 6; i++){
		cout << A[i] << " ";
	}
	
return 0;
}
