#include <bits/stdc++.h>
using namespace std;

            //! using loops O(n) time | O(n) space
vector<int> spiralTraverse(vector<vector<int>> array) {

        
        vector <int> result = {};
        int startRow = 0, endRow = array.size() - 1;
        int startCol = 0, endCol = array[0].size() - 1;

        while ((startRow <= endRow) && (startCol <= endCol)) { 

                    for (int col = startCol; col <= endCol; col++) {
                        result.push_back(array[startRow][col]);
                    }
                     for (int row = startRow + 1; row <= endRow; row++) {
                         result.push_back(array[row][endCol]);
                     }
                     for (int col = endCol - 1; col >= startCol; col--) {
                        result.push_back(array[endRow][col]);
                     }
                     for(int row = endRow + 1; row < startRow; row++) {
                         result.push_back(array[row][startCol]);
                     }
                     startRow++;
                     endRow--;
                     startCol++;
                     endCol--
        }

        return result;


}

//! Using Recursion


int spiralTraverse(int array[][]) {
    vector<int> result = {};
    spiralFill(array, 0, array.size() - 1, 0, array[0].size() - 1, result);
    return result;

}

spiralFill(int array[][], int startRow, int endRow, int startCol, endCol, vector<int> result = {}) {

            if (startRow > endRow || startCol > endCol) {
                return;
            }

            for (int col = startCol; col <= endCol; col++)
            {
                result.push_back(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++)
            {
                result.push_back(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--)
            {
                result.push_back(array[endRow][col]);
            }
            for (int row = endRow + 1; row < startRow; row++)
            {
                result.push_back(array[row][startCol]);
            }
            spiralFill(int array[][], int startRow + 1, int endRow -1, int startCol + 1, endCol - 1, vector<int> result = {})
}   


