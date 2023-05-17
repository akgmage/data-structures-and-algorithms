/*This implementation uses a vector<int> to store the elements to be sorted. The heapify function is used to create a max heap and maintain the heap property. The heapSort function performs the heap sort algorithm by repeatedly extracting the maximum element from the heap. Finally, the printArray function is a utility function to print the elements of an array.*/
/* time complexity O(n log n)
   Space  complexity  O(1) */
#include <iostream>
#include <vector>

using namespace std;

void heapify(vector<int>& arr, int n, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // Left child
    int right = 2 * i + 2; // Right child

    // If left child is larger than root
    if (left < n && arr[left] > arr[largest])
        largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest])
        largest = right;

    // If largest is not root
    if (largest != i) {
        swap(arr[i], arr[largest]);

        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}

void heapSort(vector<int>& arr) {
    int n = arr.size();

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
        // Move current root to end
        swap(arr[0], arr[i]);

        // call max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}

// Utility function to print an array
void printArray(const vector<int>& arr) {
    for (int i = 0; i < arr.size(); ++i)
        cout << arr[i] << " ";
    cout << endl;
}

int main() {
    vector<int> arr = {12, 11, 13, 5, 6, 7};
    cout << "Original array: ";
    printArray(arr);

    heapSort(arr);

    cout << "Sorted array: ";
    printArray(arr);

    return 0;
}
