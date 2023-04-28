#include <iostream>
#include <vector>

using namespace std;

bool IsMonotonic(vector<int>& array) {
    bool isNonDecreasing = true; // flag to track if array is non-decreasing
    bool isNonIncreasing = true; // flag to track if array is non-increasing
    
    // iterate through the array starting at index 1
    for (int i = 1; i < array.size(); i++) {
        if (array[i] < array[i - 1]) {
            // if the current element is less than the previous element, array is not non-decreasing
            isNonDecreasing = false;
        }
        if (array[i] > array[i - 1]) {
            // if the current element is greater than the previous element, array is not non-increasing
            isNonIncreasing = false;
        }
    }
    
    // if either flag is true, return true indicating that array is monotonic
    return isNonDecreasing || isNonIncreasing;
}