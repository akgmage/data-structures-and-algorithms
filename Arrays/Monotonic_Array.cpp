/*The problem is about determining whether an array is monotonic. A monotonic array is defined as an array that is either entirely non-increasing or non-decreasing.*/
/*The time complexity of the isMonotonic function is O(n)
The space complexity of the isMonotonic function is O(1)*/

#include <iostream>
#include <vector>

using namespace std;

// Function to check if an array is monotonic
bool isMonotonic(const vector<int>& array) {
    const int size = array.size();
    bool increasing = true;
    bool decreasing = true;

    // Iterate over the array
    for (int i = 1; i < size; i++) {
        // Check for non-increasing condition
        if (array[i] < array[i - 1])
            increasing = false;

        // Check for non-decreasing condition
        if (array[i] > array[i - 1])
            decreasing = false;
    }

    // Return true if either increasing or decreasing condition holds
    return increasing || decreasing;
}

int main() {
    vector<int> arr1 = {1, 2, 3, 4, 5};         // Monotonic (Increasing)
    vector<int> arr2 = {5, 4, 3, 2, 1};         // Monotonic (Decreasing)
    vector<int> arr3 = {1, 2, 2, 3, 1};         // Not Monotonic
    vector<int> arr4 = {1, 1, 1, 1, 1};         // Monotonic (Increasing)
    vector<int> arr5 = {5, 5, 5, 5, 5};         // Monotonic (Increasing)

    cout << "Array 1 is monotonic: " << boolalpha << isMonotonic(arr1) << endl;
    cout << "Array 2 is monotonic: " << boolalpha << isMonotonic(arr2) << endl;
    cout << "Array 3 is monotonic: " << boolalpha << isMonotonic(arr3) << endl;
    cout << "Array 4 is monotonic: " << boolalpha << isMonotonic(arr4) << endl;
    cout << "Array 5 is monotonic: " << boolalpha << isMonotonic(arr5) << endl;

    return 0;
}
