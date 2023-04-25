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
