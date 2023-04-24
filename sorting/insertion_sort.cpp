/*
	In this implementation, we define a function called InsertionSort that takes an array of integers and sorts
	it in ascending order using the Insertion Sort algorithm.

	The algorithm works by iterating over the array from the second element to the end.

	For each element, it compares it with the previous elements in the array and inserts it in the correct position.

	The current variable holds the value of the current element being compared.

	The j variable holds the index of the previous element being compared.

	The loop compares the current value with the previous values in the array and shifts the values to the right to make space for the current value.

	Once the correct position is found, the current value is inserted into the array.

	Finally, the sorted array is returned. In the main function, we define an array of integers, sort it using the InsertionSort function, and print the sorted array.

	Sample input: [0, 2, 1,-1, 10, 3, 4]
	Output: [-1 0 1 2 3 4 10]
*/

#include <iostream>
#include <vector>

using namespace std;


// InsertionSort is a function that takes an array of integers and sorts it in
// ascending order using the Insertion Sort algorithm.
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
