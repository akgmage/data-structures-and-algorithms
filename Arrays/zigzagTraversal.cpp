#include <bits/stdc++.h>

using namespace std;

int zigzagTraversal (int arr[9][9]) {
    int height = sizeof(arr) / sizeof(arr[0]) - 1;
    int width = sizeof(arr[0])/sizeof(arr[0][0]) - 1;
    vector<int> result = {};
    int row = 0, col = 0;
    bool goingDown = true;

    while (!isOutOfBound(row, height, col, width)) {
            result.push_back(arr[row][col]);
                if (goingDown) {
                    if (col == 0 || row == height) {
                        goingDown = false;
                        if (row == height) {
                            col += 1;
                            else (col == 0) {
                                row += 1;
                            }
                        } else {
                            row += 1;
                            col -= 1;
                        }
                    } else {
                        if (row == 0 || col == width) {
                            goingDown = true;
                            if (col == width) {
                                row += 1;
                            } else {
                                col += 1;
                            }
                         } else {
                             row -= 1;
                             col += 1;
                         }
                    }

                }
    }
    return result; 
}
    
    bool isOutOfBound(row, col, height, width)
        {
            return (row < 0 || row > height || col < 0 || col > width);
        }
int main () {

   int arr[9][9] = {
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
   };

    cout << zigzagTraversal(arr[9][9]) << endl;

   
   return 0;
} 