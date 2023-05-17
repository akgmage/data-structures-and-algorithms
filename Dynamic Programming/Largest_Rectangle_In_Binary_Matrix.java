//Program Author : TheCodeVenturer [Niraj Modi]
/*
    Problem Definition:
        Dynamic Programming: Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area in Python
    Approach:
        This Problem can be termed as updated version of Largest Rectangle in Histogram
        If you are given a binary matrix then you can use no.of rows together with one as height
        Like 
        0 1 1 0
        1 1 1 1
        1 1 1 1
        1 1 0 0
        If you can Visualise then it will be clear that for 
        first row the histogram row is like [0,1,1,0]
        second row the histogram row is like [1,2,2,1]
        third row the histogram row is like [2,3,3,2]
        fourth row the histogram row is like [3,4,0,0]
        then by using a monotonic stack for each row we can get The Largest Rectangle in the Binary Matrix

        we are taking here a row list which keeps track of current height of a particular column . Here, ShiftRow
        we are also using a solution variable to keep track of largest rectangle
        then first we will iterate through each row 
            and inside each iteration we will go and look for the particular element of that row matrix[i][j]
            if it is 1 then will increase size of jth entry in the shiftRow else will convert it to zero
            next will initialize an empty Stack [Monotonic]
            next we will iterate through the shiftRow and will first check for the list is not empty and (it's top element is greater than or equal to current element or value of current column is equal to row size)
                then will store it's height from the current row array and will update width of the rectangle with stack's top element and will finally update the sol
            and will insert the element to the stack
        Complexity:
        Time Complexity: O(rows * col) for for traversing through each elements of the array 
                Here in each iteration we are doint three times O(n) => O(3n) ~ O(n)
        Space Complexity: O(n) for the shiftRow and O(n) for the stack we are using => O(2n) ~ O(n)
        Sample input/outputs:
		Example 1:
		Input: [[0,1,1,0],[1,1,1,1],[1,1,1,1],[1,1,0,0]]
		Output: 8

		Example 2:
		Input: [[0,1,1],[1,1,1],[0,1,1]] 
		Output: 6
*/
import java.util.*;

public class Solution {
    public static int maxArea(int[][] matrix, int rows, int cols) {
        int[] shiftRow = new int[cols]; // initializing the row which updates after each iteration
        int sol = 0;
        
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                // Updating the shiftRow if the value of ele is 1 => shiftRow[i] <- shiftRow[i] + 1
                // else shiftRow[i] = 0
                int ele = row[i];
                if (ele == 1) shiftRow[i]++;
                else shiftRow[i] = 0;
            }
            
            Deque<Integer> stack = new ArrayDeque<>();
            
            for (int i = 0; i < cols + 1; i++) {
                while (!stack.isEmpty() && (i == cols || shiftRow[stack.peek()] >= shiftRow[i])) {
                    // checking TOS (top of stack) stack.length - 1
                    int height = shiftRow[stack.peek()]; // for getting the height of the current index
                    stack.pop();
                    int width = i; // setting width to i as it is only smallest from the beginning
                    if (!stack.isEmpty()) width = i - stack.peek() - 1; // updating width if the stack is not empty as it is not the smallest element
                    sol = Math.max(height * width, sol); // updating the sol
                }
                
                stack.push(i); // pushing the element's index to the stack
            }
        }
        
        return sol;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };
        
        System.out.println(maxArea(matrix, 4, 4));
    }
}

  