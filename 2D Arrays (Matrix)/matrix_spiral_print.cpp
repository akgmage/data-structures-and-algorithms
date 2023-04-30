// Printing Matrix in spiral order 
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