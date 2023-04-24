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

#include <iostream>
#include <vector>

using namespace std;

void insertionSort(vector<int>& arr) {
    int n = arr.size();
    for(int i=1; i<n; i++) { // i starts from 1 as we assume 1st element is already sorted
        int key = arr[i]; // assign key with current element which needs to be compared and sorted
        int j = i-1; // set the index j to previous element
        
        /* Move elements of arr[0..i-1], that are greater than key, to one position ahead 
        of their current position */
        while(j>=0 && arr[j]>key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key; // insert the key at its sorted position
    }
}

int main() {
    vector<int> arr = {3, 5, 1, 4, 2};
    insertionSort(arr);

    cout << "Sorted Array: ";
    for(int num: arr) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}
