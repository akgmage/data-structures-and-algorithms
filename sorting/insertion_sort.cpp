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
