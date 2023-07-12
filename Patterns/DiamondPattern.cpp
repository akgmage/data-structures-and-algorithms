/*
Approach:
1. We use two nested loops to iterate through each row and each column of the diamond pattern.
2. The first loop is used to iterate through the rows of the diamond. It starts from 0 and goes up to n-1 rows for the upper half of the diamond.
3. Inside the first loop, we use a nested loop to print spaces before the pattern of each row. The number of spaces decreases by 1 as we move down the rows.
4. Again inside the first loop, we use another nested loop to print the pattern of asterisks (*) for each row. The number of asterisks increases by 2 as we move down the rows.
5. After printing each row, we move to the next line using `cout << endl;`.
6. Now, we need to print the lower half of the diamond. For this, we use another loop that starts from n-2 (as we have already printed the top-most row in the first loop) and moves down to 0 rows.
7. Inside this loop, we print the spaces and pattern the same way as in the first loop.
8. Finally, we have the main function where we take input from the user for the number of rows and call the `printDiamondPattern` function.

Time Complexity: O(n^2) - as we use nested loops to iterate through each row and each column of the diamond pattern.

Space Complexity: O(1) - as we only use a constant amount of additional space for variables.

Sample Input:
Enter the number of rows: 5

Sample Output:
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
*/


#include <iostream>
using namespace std;

void printDiamondPattern(int n) {
    // Print the upper half of the diamond
    for (int i = 0; i < n; i++) {
        // Print spaces before the pattern for each row
        for (int j = 0; j < n - i - 1; j++) {
            cout << " ";
        }
        
        // Print the pattern for each row
        for (int j = 0; j < 2 * i + 1; j++) {
            cout << "*";
        }
        
        cout << endl; // Move to the next line
    }
    
    // Print the lower half of the diamond
    for (int i = n-2; i >= 0; i--) {
        // Print spaces before the pattern for each row
        for (int j = 0; j < n - i - 1; j++) {
            cout << " ";
        }
        
        // Print the pattern for each row
        for (int j = 0; j < 2 * i + 1; j++) {
            cout << "*";
        }
        
        cout << endl; // Move to the next line
    }
}

int main() {
    int n;
    cout << "Enter the number of rows: ";
    cin >> n;
    
    printDiamondPattern(n);

    return 0;
}



