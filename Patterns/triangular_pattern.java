/*
Approach:
- Initialize the `rows` variable to determine the number of rows in the pattern.
- Initialize the `count` variable to keep track of the current number.
- Use nested `for` loops to iterate through the rows and columns.
- Print the current `count` value and increment it after printing.
- Move to the next line after each row by using `System.out.println()`.

Time Complexity: The nested loops iterate through the rows and columns of the pattern, resulting in a time complexity of O(rows^2).

Space Complexity: The space complexity is O(1) as we only require a few variables to store the number of rows, current count, and loop indices.

Sample Input (rows = 5):
5

Sample Output:
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
*/

//Java code for generating a number pattern in a triangular pattern, starting from 1:

public class triangular_pattern {
    public static void main(String[] args) {
        int rows = 5; // number of rows in the pattern

        int count = 1; // variable to keep track of the current number
      
        // loop through the rows
        for (int i = 1; i <= rows; i++) {
            // loop through the columns
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println(); // move to the next line after each row
        }
    }
}

