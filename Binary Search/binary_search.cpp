/*
    The binarySearch function takes in a sorted vector of integers arr and a target value target to search for.
    The function initializes the left and right pointers to the first and last indices of the array respectively.
    The function uses a while loop to keep searching until the left and right pointers meet.
    Inside the loop, the function calculates the middle index by adding the left and right indices and dividing by 2.
    If the middle element is equal to the target, the function returns the middle index.
    If the target is greater than the middle element, the function discards the left half of the array and moves the left pointer to the middle + 1 index.
    If the target is smaller than the middle element, the function discards the right half of the array and moves the right pointer to the middle - 1 index.
    If the target is not found in the array, the function returns -1.
    The driver code initializes a sorted array and a target value, and calls the binarySearch function to search for the target value.
    The function returns the index of the target value, or -1 if it is not found.
    The driver code prints the result of the search to the console.
*/
#include <iostream>
#include <vector>

using namespace std;

// Binary search function
// Takes in a sorted vector of integers and a target value to search for
// Returns the index of the target value if found, -1 otherwise
int binarySearch(vector<int> arr, int target) {
    int left = 0;
    int right = arr.size() - 1;
    
    // Loop until left and right pointers meet
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        // If the target is found, return the index
        if (arr[mid] == target) {
            return mid;
        }
        // If target is greater than the middle element, discard the left half
        else if (arr[mid] < target) {
            left = mid + 1;
        }
        // If target is smaller than the middle element, discard the right half
        else {
            right = mid - 1;
        }
    }
    
    // Target not found
    return -1;
}

// Driver code to test binary search function
int main() {
    vector<int> arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    int target = 12;
    int result = binarySearch(arr, target);
    
    if (result == -1) {
        cout << "Element not found" << endl;
    }
    else {
        cout << "Element found at index " << result << endl;
    }
    return 0;
}
