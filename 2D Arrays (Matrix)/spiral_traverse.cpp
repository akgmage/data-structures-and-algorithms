/*
	Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and
	returns a one-dimensional array of all the array's elements in spiral order.

	Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds
	in a spiral pattern all the way until every element has been visited.

	Explanation:

	The SpiralTraverse function takes a 2D integer array array and returns a 1D integer slice that contains the
	elements of array traversed in a spiral order, starting from the top-left corner and moving clockwise.

	The function first initializes an empty slice result to hold the elements of the spiral traversal.
	If the input array is empty, the function immediately returns the empty result.

	Next, the function initializes variables startRow, endRow, startCol, and endCol to keep track of the
	boundaries of the matrix. These variables will be updated as the function traverses the matrix.

	The function then enters a loop that traverses the matrix in a spiral order. The loop continues
	as long as startRow <= endRow and startCol <= endCol, which means that there are still elements
	in the matrix to be traversed.

	The first step in the loop is to traverse the top row of the matrix from left to right, and append
	each element to the result slice. The next step is to traverse the rightmost column of the matrix from top to bottom,
	and append each element to the result slice. If there is more than one row in the matrix, the function then traverses
	the bottom row of the matrix from right to left, and appends each element to the result slice. If there is only one row left,
	the loop is broken to avoid duplicating the elements. Finally, if there is more than one column in the matrix,
	the function traverses the left

	O(n) time | O(n) space - where n is the total number of elements in the array
*/
#include<bits/stdc++.h>
using namespace std;

#include <vector>
using namespace std;

vector<int> SpiralTraverse(vector<vector<int>> array) {
    vector<int> result; // vector to store the spiral traversal
    int rows = array.size(); // number of rows in the input array
    int cols = array[0].size(); // number of columns in the input array
    int startRow = 0, endRow = rows - 1; // indices for the start and end row of the current subarray
    int startCol = 0, endCol = cols - 1; // indices for the start and end column of the current subarray

    // loop until the entire input array is traversed
    while (startRow <= endRow && startCol <= endCol) {
        // traverse the top row from left to right
        for (int col = startCol; col <= endCol; col++) {
            result.push_back(array[startRow][col]);
        }
        // traverse the right column from top to bottom
        for (int row = startRow + 1; row <= endRow; row++) {
            result.push_back(array[row][endCol]);
        }
        // traverse the bottom row from right to left
        for (int col = endCol - 1; col >= startCol; col--) {
            // check if there is only one row in the subarray
            if (startRow == endRow) {
                break;
            }
            result.push_back(array[endRow][col]);
        }
        // traverse the left column from bottom to top
        for (int row = endRow - 1; row > startRow; row--) {
            // check if there is only one column in the subarray
            if (startCol == endCol) {
                break;
            }
            result.push_back(array[row][startCol]);
        }
        // update the indices for the next subarray to be traversed
        startRow++;
        endRow--;
        startCol++;
        endCol--;
    }

    return result;
}

int main() {
    vector<vector<int>> array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    vector<int> result = SpiralTraverse(array);
    cout << "Spiral traversal: ";
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }
    cout << endl;
    return 0;
}