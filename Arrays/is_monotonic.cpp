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

int main() {
    // example usage
    vector<int> arr = {1, 2, 3, 3, 4, 5};
    bool isMonotonic = IsMonotonic(arr);
    cout << "Array is monotonic: " << isMonotonic << endl;
    
    return 0;
}