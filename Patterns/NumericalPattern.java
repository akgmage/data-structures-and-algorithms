/*
Problem:
This program prints a pattern of numbers in an organized way.
The numbers start from 1 and increase in a triangular pattern.
Each row in the pattern contains the numbers from 1 to the row number.
The row numbers increase from 1 to the given input number.
 
Approach:
- Use nested loops to iterate through each row and each number within the row.
- The outer loop controls the row number and runs from 1 to the input number.
- The inner loop prints the numbers for each row and runs from 1 to the row number.
- Print each number followed by a space.
- After each row is printed, insert a new line.

Time Complexity: O(n^2), where n is the given input number. This is because we have nested loops that iterate n times.
Space Complexity: O(1) as no extra space is required other than the given input.
 
Sample Input 1:
5
Sample Output 1:
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
 
Sample Input 2:
3
Sample Output 2:
1
1 2
1 2 3
*/

public class NumericalPattern {
    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {           // iterate through each row
            for (int j = 1; j <= i; j++) {       // iterate through each number within the row
                System.out.print(j + " ");      // print the number followed by a space
            }
            System.out.println();               // insert a new line after each row
        }
    }
    
    public static void main(String[] args) {
        int n = 5;   // sample input
        printPattern(n);
    }
}
