/* SET MATRIX ZERO - JAVA LANGUAGE
   Problem Link1 : https://leetcode.com/problems/set-matrix-zeroes/
   Problem Link2 : https://www.codingninjas.com/codestudio/problems/zero-matrix_1171153	
	
Problem:
You are given a 2D matrix, and the task is to modify it such that if an element in the matrix is zero, you need to set all the elements in the 
corresponding row and column to zero as well. 

E.g- Input: | 1 1 1 |
	        | 1 0 1 |
	        | 1 1 1 |

    Output: | 1 0 1 |
	        | 0 0 0 |
	        | 1 0 1 |
	
METHOD 1] Brute Force Approach for Set Matrix Zeroes
Step 1. Create an array answer of size (n X m) and initialize every element as 1.
Step 2. Traverse the matrix array row-wise and set the current row as 0 in answer array if the current row contains an element equals to 0.
Step 3. Traverse the matrix array column-wise and set the current column as 0 in answer array if the current column contains an element equals to 0.
Step 4. Now traverse the answer array, if the current element is 0, then set this element as 0 in a matrix array.
Step 5. Return matrix array

Complexity Analysis:
Time Complexity = O(n * m)
Space Complexity = O(n * m) 
where n is the number of rows in the matrix and m is the number of columns in the matrix.

METHOD 2] Optimal Approach for Set Matrix Zeroes
If we assume that -1, do not occur in the matrix array, then

Step 1. Traverse the matrix array row-wise and set all the elements of current row which are not 0 as -1, if the current row contains an element equals to 0.
Step 2. Traverse the matrix array column-wise and set all the elements of the current column which are not 0 as -1, if the current column contains an element equals to 0.
Step 3. Again traverse the matrix and set all the elements that are -1 to 0.
Step 4. Return matrix array.
	
Complexity Analysis:
Time Complexity = O(n * m)
Space Complexity = O(1) 
where n is the number of rows in the matrix and m is the number of columns in the matrix.
*/


public class setMatrixZero {

    // Method 1] Brute Force Approach
    private static void setZeroes_bruteForce(int[][] matrix, int n, int m) {
        int answer[][] = new int[n][m]; // Step 1
        // Set all elements of answer array as 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = 1; // making each element as 1
            }
        }
        // Traverse row wise --> Step 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Set this row as zero in answer array
                    for (int k = 0; k < m; k++) {
                        answer[i][k] = 0;
                    }
                    break;
                }
            }
        }
        // Traverse column wise --> Step 3
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 0) {
                    // Set this column as 0 in answer array
                    for (int k = 0; k < n; k++) {
                        answer[k][j] = 0;
                    }
                }
            }
        }
        // Update the elements in matrix array --> Step 4
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (answer[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Method 2] Optimal Approach
    private static void setZeroes_optimalMethod(int[][] matrix, int n, int m) {
        // Traverse row wise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Set all the elements that are not zero as -1
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = -1;
                        }
                    }
                }
            }
        }
        // Traverse column wise
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 0) {
                    // Set all the elements that are not zero as -1
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = -1;
                        }
                    }
                }
            }
        }
        
        // Update all -1 as 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Example using Method 1 - Brute Force
        int[][] matrix1 = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};    //  Defining Matrix
        int n = matrix1.length;
        int m = matrix1[0].length;

        setZeroes_bruteForce(matrix1, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");  // Printing Matrix
            }
            System.out.println();
        }

        System.out.println("-----------------");

        // Example using Method 2 - Optimal 
        int[][] matrix2 = new int[][] {{0, 0, 6, 0}, {1, 4, 9, 0}, {1, 8, 1, 8}};   //  Defining Matrix
        n = matrix2.length;
        m = matrix2[0].length;

        setZeroes_optimalMethod(matrix2, n, m);

        for (int i = 0; i < n; i++) {   
            for (int j = 0; j < m; j++) {
                System.out.print(matrix2[i][j] + " ");  // Printing Matrix
            }
            System.out.println();
        }
    }
}