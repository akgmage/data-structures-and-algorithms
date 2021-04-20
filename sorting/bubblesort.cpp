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
				flag = 1;
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
