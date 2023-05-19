/*

Follow the given steps to solve the problem:

Run a nested loop, outer loop for the row, and inner loop for the column
Check every element with x and if the element is found then print “element found”
If the element is not found, then print “element not found”

Time Complexity: O(N2)
Auxiliary Space: O(1), since no extra space has been taken.

*/

#include <bits/stdc++.h>
 
using namespace std;
 
/* Searches the element x in mat[][]. If the
element is found, then prints its position
and returns true, otherwise prints "not found"
and returns false */
int search(int mat[4][4], int n, int x)
{
    if (n == 0)
        return -1;
 
    // traverse through the matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            // if the element is found
            if (mat[i][j] == x) {
                cout << "Element found at (" << i << ", "
                     << j << ")\n";
                return 1;
            }
    }
 
    cout << "n Element not found";
    return 0;
}
 
// Driver code
int main()
{
    int mat[4][4] = { { 10, 20, 30, 40 },
                      { 15, 25, 35, 45 },
                      { 27, 29, 37, 48 },
                      { 32, 33, 39, 50 } };
 
    // Function call
    search(mat, 4, 29);
 
    return 0;
}
 