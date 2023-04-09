// Rotate clockwise and anti-clockwise
/*
    This program takes a 2D array (matrix) and performs two types of 90-degree rotations: clockwise and 
    anti-clockwise. The rotateClockwise method takes a matrix and returns a new matrix with its 
    elements rotated 90 degrees clockwise. The rotateAntiClockwise method takes a matrix and 
    returns a new matrix with its elements rotated 90 degrees anti-clockwise.

    The printMatrix method is used to print the matrix elements in a readable format. 
    Finally, the main method initializes a test matrix and performs the two rotations on it.
*/
public class RotateMatrix {

    // Rotate matrix by 90 degrees clockwise
    public static int[][] rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[n - j - 1][i];
            }
        }

        return result;
    }

    // Rotate matrix by 90 degrees anti-clockwise
    public static int[][] rotateAntiClockwise(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[j][n - i - 1];
            }
        }

        return result;
    }

    // Print matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Test program
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] rotatedClockwise = rotateClockwise(matrix);
        System.out.println("Matrix after 90 degree clockwise rotation:");
        printMatrix(rotatedClockwise);

        int[][] rotatedAntiClockwise = rotateAntiClockwise(matrix);
        System.out.println("Matrix after 90 degree anti-clockwise rotation:");
        printMatrix(rotatedAntiClockwise);
    }
}
