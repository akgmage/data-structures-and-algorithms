/*
	Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
	whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from
	the first array in the first position.

	Note that the absolute difference of two integers is the distance between them on the real number line.
	For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

  	You can assume that there will only be one pair of numbers with the smallest difference.

	Sample Input Array1 = [-1, 5, 10, 20, 28, 3]
	Sample Input Array2 = [26, 134, 135, 15, 17]

	Sample Output = [28, 26]


    The code finds the pair of elements from two arrays, array1 and array2, whose absolute difference is the smallest 
    among all possible pairs. It does this by first sorting both arrays and then using two pointers (idx1 and idx2) 
    to iterate through the arrays. At each iteration, it compares the current element of array1 and array2, 
    and updates smallest (the smallest absolute difference so far) and result (the pair of elements that give 
    the smallest absolute difference) if the absolute difference between the current elements is smaller than 
    the current smallest. The function returns the result at the end.

    Time complexity: O(nlog(n) + mlog(m)), where n and m are the lengths of array1 and array2, respectively
    Space complexity: O(1)
*/
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

// SmallestDifference takes in two Vector of integers and returns a pair of integers, one from each Vector, such that their
// absolute difference is as close to zero as possible. If multiple pairs have the same absolute difference, SmallestDifference
// returns the pair whose elements come first in the respective slices.
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
