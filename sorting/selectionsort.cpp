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
