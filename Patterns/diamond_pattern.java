/*
Approach:
1. We take the number of rows for the diamond pattern as input.
2. We start by printing the upper half of the diamond pattern. In each row, we first print the required spaces and then print the required number of asterisks.
3. After the upper half, we print the lower half of the diamond pattern using a similar logic.

Time Complexity: The time complexity of this code is O(n^2) as we use nested loops to print the pattern.

Space Complexity: The space complexity of this code is O(1) as we are not using any additional data structures.

Sample Input: 5

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

public class DiamondPattern {

    public static void main(String[] args) {
        int n = 5; // Specify the number of rows for the diamond pattern
        printDiamondPattern(n);
    }

    public static void printDiamondPattern(int n) {
        if (n <= 0) {
            System.out.println("Number of rows should be positive.");
            return;
        }

        // Printing upper half of the diamond pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Printing lower half of the diamond pattern
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


