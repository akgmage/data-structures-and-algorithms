/*
Program: To generate a hollow pattern using asterisks ('*'). The program will take an integer 'n' as input, which represents the size of the pattern, and it will produce a hollow pattern of the given size.

Approach:
1. We will use nested loops to iterate through rows and columns and print '*' at specific positions to form the hollow pattern.
2. For each row, we will check if it's the first row, last row, first column, or last column. If so, we will print a '*' character. Otherwise, we will print a space ' '.
3. This way, we will create the desired hollow pattern.

Time Complexity: O(n^2)
- The program uses two nested loops to print the pattern, one for rows and one for columns. So, the time complexity is proportional to the square of 'n'.

Space Complexity: O(1)
- The program uses a constant amount of extra space, as it only prints characters and does not use any additional data structures that depend on the input size 'n'.

Sample Input: 6
Sample Output:
* * * * * * 
*         * 
*         * 
*         * 
*         * 
* * * * * *

*/

import java.util.Scanner;

public class HollowPattern {
    public static void printHollowPattern(int n) {
        // Iterate through each row
        for (int i = 0; i < n; i++) {
            // Iterate through each column in the row
            for (int j = 0; j < n; j++) {
                // Check if it's the first row, last row, first column, or last column
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            // Move to the next line after each row is printed
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the pattern: ");
        int size = scanner.nextInt();

        printHollowPattern(size);
    }
}
