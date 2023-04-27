/*
  Write a function that takes in an array of at least three integers and,
  without sorting the input array, returns a sorted array of the three largest
  integers in the input array.
*/
/* Explanation
   This code defines a function called `FindThreeLargestNumbers` that takes an array of integers as input and
   returns an array of the three largest integers in the input array.

   The `triplets` array is initialized with three smallest possible values. Then, the function iterates through
   the input array using a `for` loop and calls the `updateLargest` function to update the `triplets` array with
   the current number if it is larger than one of the values in the array.

   The `updateLargest` function takes two arguments: `triplets` and `num`. It first checks if `num` is greater
   than the third value in the `triplets` array. If so, it calls the `shiftAndUpdate` function to update the
   `triplets` array with the current number at the third index.

   If `num` is not greater than the third value in the `triplets` array, it checks if `num` is greater than the second value in the `triplets` array.

   If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
   the second index. Finally, if `num` is not greater than either the third or second value in the `triplets`
   array, it checks if `num` is greater than the first value in the `triplets` array.

   If so, it calls the `shiftAndUpdate` function to update the `triplets` array with the current number at
   the first index.

   The `shiftAndUpdate` function takes three arguments: `triplets`, `num`, and `idx`. It iterates through the
   `triplets` array using a `for` loop and shifts each value to the left by one position until it reaches
   the `idx` index. Then it updates the value at the `idx` index with the current number `num`.

   Time and Space complexity : O(n) time | O(1) space - where n is the length of the input array
*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

// Function to update the triplet if the input number is larger than any of its elements.
void updateLargest(vector<int>& triplets, int num);

// Function to shift the elements of the triplet to make room for a new number and add the number to the specified index.
void shiftAndUpdate(vector<int>& triplets, int num, int idx);

// Function to find the three largest integers in the input array in descending order.
vector<int> findThreeLargestNumbers(vector<int>& array);

int main() {
    // Create an input array.
    vector<int> array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};

    // Find the three largest integers in the input array.
    vector<int> result = findThreeLargestNumbers(array);

    // Output the three largest integers in descending order.
    for (int num : result) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}

vector<int> findThreeLargestNumbers(vector<int>& array) {
    // Initialize a vector to hold the three largest integers, starting with negative infinity.
    vector<int> triplets = {INT_MIN, INT_MIN, INT_MIN};

    // Iterate over each number in the input array and call the updateLargest function to determine if it should be included in the triplet.
    for (int num : array) {
        updateLargest(triplets, num);
    }

    // Return the vector containing the three largest integers in descending order.
    return triplets;
}

void updateLargest(vector<int>& triplets, int num) {
    // If the number is larger than the third-largest element in the triplet, shift the other elements to make room and add the number.
    if (num > triplets[2]) {
        shiftAndUpdate(triplets, num, 2);
    // Otherwise, if the number is larger than the second-largest element, shift and update the triplet accordingly.
    } else if (num > triplets[1]) {
        shiftAndUpdate(triplets, num, 1);
    // Otherwise, if the number is larger than the first-largest element, shift and update the triplet accordingly.
    } else if (num > triplets[0]) {
        shiftAndUpdate(triplets, num, 0);
    }
}

void shiftAndUpdate(vector<int>& triplets, int num, int idx) {
    // Shift the elements of the triplet to the right starting at the specified index, and add the new number to the specified index.
    for (int i = 0; i < idx + 1; i++) {
        // If the loop reaches the specified index, add the new number to the triplet.
        if (i == idx) {
            triplets[i] = num;
        // Otherwise, shift the elements to the right.
        } else {
            triplets[i] = triplets[i + 1];
        }
    }
}
