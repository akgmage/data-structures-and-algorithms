// Merge Sort
/*
	Here's how the merge sort algorithm works:

	1. It divides the input array into two halves, recursively sorts them, and then merges the sorted halves.
	2. To merge two sorted sub-arrays, we need to create a temporary array and then compare the elements of the two sub-arrays, 
	   one by one, and add the smaller element to the temporary array.
	3. After we have exhausted one of the sub-arrays, we simply copy the remaining elements of the other sub-array to the temporary array.
	4. Finally, we copy the elements of the temporary array back to the original array.

	The time complexity of merge sort is O(n log n), where n is the number of elements in the array. 
	The space complexity is O(n), because we create a temporary array of size n during the merging process.
*/
#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& arr, int start, int mid, int end) {
    vector<int> temp(end - start + 1);
    int i = start, j = mid + 1, k = 0;

    while (i <= mid && j <= end) {
        if (arr[i] <= arr[j]) {
            temp[k] = arr[i];
            ++i;
        } else {
            temp[k] = arr[j];
            ++j;
        }
        ++k;
    }

    while (i <= mid) {
        temp[k] = arr[i];
        ++i;
        ++k;
    }

    while (j <= end) {
        temp[k] = arr[j];
        ++j;
        ++k;
    }

    for (int l = start; l <= end; ++l) {
        arr[l] = temp[l - start];
    }
}

void merge_sort(vector<int>& arr, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}

int main() {
    vector<int> arr = {5, 2, 8, 1, 9, 4};
    merge_sort(arr, 0, arr.size() - 1);
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}