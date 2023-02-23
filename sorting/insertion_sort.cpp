/*
Implementation of insertion sort in C++.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
*/

#include<bits/stdc++.h>
using namespace std;

void InsertionSort(int A[], int n){
	int flag = 0;
	for(int i = 1; i < n; i++){
		int hole = i;
		int value = A[i];
		while(hole > 0 && A[hole-1] > value){
			A[hole] = A[hole-1];
			hole = hole - 1;
		}
		A[hole] = value;
	}
}
int main(){
	int A[] = {5,9,77,1,2,3,4,5};
	InsertionSort(A,6);
	for(int i = 0; i < 6; i++){
		cout << A[i] << " ";
	}
	
return 0;
}
