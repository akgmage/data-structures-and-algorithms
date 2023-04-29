#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

// SmallestDifference takes in two slices of integers and returns a pair of integers, one from each slice, such that their
// absolute difference is as close to zero as possible. If multiple pairs have the same absolute difference, SmallestDifference
// returns the pair whose elements come first in the respective slices.
// Time complexity: O(nlog(n) + mlog(m)), where n and m are the lengths of array1 and array2, respectively
// Space complexity: O(1)
vector<int> SmallestDifference(vector<int> array1, vector<int> array2) {
    // Initialize variables to track the smallest absolute difference seen so far and the current absolute difference
    int current = INT_MAX, smallest = INT_MAX;
    // Sort the input arrays in ascending order to enable efficient searching for the pair with the smallest absolute difference
    sort(array1.begin(), array1.end());
    sort(array2.begin(), array2.end());
    // Initialize variables to track the current index in each array
    int idx1 = 0, idx2 = 0;
    // Initialize an empty vector to store the pair of integers with the smallest absolute difference
    vector<int> result;
    // Loop through both arrays until the end of at least one of them is reached
    while (idx1 < array1.size() && idx2 < array2.size()) {
        // Get the current elements from both arrays
        int first = array1[idx1], second = array2[idx2];
        // Compute the absolute difference between the current elements
        if (first < second) {
            current = second - first;
            idx1++;
        } else if (second < first) {
            current = first - second;
            idx2++;
        } else {
            // If the current elements are equal, we have found a pair with an absolute difference of 0 and can return it
            return vector<int>{first, second};
        }
        // If the current absolute difference is smaller than the smallest seen so far, update the smallest difference and the result vector
        if (smallest > current) {
            smallest = current;
            result = vector<int>{first, second};
        }
    }
    // Return the pair of integers with the smallest absolute difference
    return result;
}


int main() {
    vector<int> array1 = {1, 3, 15, 11, 2};
    vector<int> array2 = {23, 127, 235, 19, 8};
    vector<int> result = SmallestDifference(array1, array2);
    cout << "Smallest difference pair: [" << result[0] << ", " << result[1] << "]" << endl;
    return 0;
}
