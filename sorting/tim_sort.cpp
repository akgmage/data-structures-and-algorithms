//Implementation of Tim Sort
//Tim Sort makes use of insertionSort and Merge function of MergeSort
//The basic idea is to divide the input array into blocks called as runs
//The size of runs varies from 32 to 64, and perform insertion sort on the runs
//Then, The runs(blocks) are merged to form the final sorted array
//
//Time Complexity of this algorithm in Best case is O(n),Average case is O(n*log(n))
//Time Complexity in Worst case is O(n*log(n)).
//This is a stable sorting algorithm
//This algorithm uses Space of O(n)
//This algorithm is used in languages like Java and Python for sorting.

#include<bits/stdc++.h>
using namespace std;
const int run=32;
void insertionSort(vector<int>&array,int l,int r)
{
	for(int i = l + 1; i <= r; i++){
		int temp = array[i];
		int j = i - 1;
		while(j >= l and array[j] > temp) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = temp;
	}
}
void merge(vector<int>&array,int l,int m,int r) {
	int len1 = m - l + 1, len2 = r - m;
	vector<int>left(len1), right(len2);
	
	for(int i = 0; i < len1; i++){
		left[i] = array[l + i];
	}
	for(int i = 0; i < len2; i++){
		right[i] = array[m + 1 + i];
	}

	int i = 0, j = 0, k = l;

	while(i < len1 and j < len2) {
		if(left[i] <= right[j])
			array[k] = left[i++];
		else array[k] = right[j++];
		k++;
	}

	while(i<len1) {
		array[k++]=left[i++];
	}

	while(j < len2) {
		array[k++] = right[j++];
	}
}

void timSort(vector<int>&array, int n) {
	// calling insertion sort on blocks of size equal to run=32
	// if the size of array is less than defined run size, then the insertion sort would have sorted the array and there is no need of merging.
	for(int i = 0; i < n; i += run) {
		insertionSort(array, i, min((i + run - 1), n - 1));
	}	
	//we merge from size run,the array merges to form sizes 64,128,...
	for(int size = run; size < n; size = 2 * size) {
		//we merge from array[left,left+size-1]
		//and array[left+size,left+2*size]
		//after every merge,we increase left by 2*size
		for(int left = 0; left < n; left += 2 * size) {
			int mid = left + size - 1;//ending point of left subarray
			int right = min((left + 2 * size - 1), n - 1);//ending point of right subarray
			if(mid < right)
				merge(array, left, mid, right); //calling the merge function
		}
	}
	for(int i: array)//printing the sorted array
		cout << i <<" ";
	//sample output 1,2,3,4,5,6,7,8,9
}
int main()
{
	vector<int> array = {9,8,7,6,5,4,3,2,1};
	int n = array.size();
	timSort(array, n);//call to TimSort function
	return 0;
}
