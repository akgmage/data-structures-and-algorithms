// Implementation of selection sort.
// Selection sort is an in-place comparison sorting algorithm.
// It has an O(n^{2}), time complexity which makes it inefficient on large lists,
// and generally performs worse than the similar insertion sort.
// Selection sort is noted for its simplicity and has performance advantages
// over more complicated algorithms in certain situations,
// particularly where auxiliary memory is limited. (Source wiki) https://en.wikipedia.org/wiki/Selection_sort

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
#include<bits/stdc++.h>
using namespace std;

void SelectionSort(int A[], int n){
	for(int i = 0; i < n - 1; i++){
		int imin = i;
		for(int j = i + 1; j < n; j++){
			if(A[j] < A[imin])
				imin = j; 
		}
		int temp = A[i];
		A[i] = A[imin];
		A[imin] = temp;
	}
}
int main(){
	int A[] = {5,4,3,6,7,8,9,1,2,10};
	SelectionSort(A,10);
	for(int i = 0; i < 10; i++){
		cout << A[i] << " ";
	}
	
return 0;
}
