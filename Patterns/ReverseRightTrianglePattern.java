/*
    Reverse Right Triangular Pattern
    Approach:
        1) Identify the numbers of rows for the outer for loop
        2) Identify the relation of column with respect to row.
            In this case col = size-row+1
        3) for each loop , print the respective element.

    TIME COMPLEXITY: O(N^2)
    SPACE COMPLEXITY: O(1)
     Eg: For size = 5,
        OUTPUT:
                * * * * *
                * * * *
                * * *
                * *
                *
 */
public class ReverseRightTrianglePattern {

    public static void main(String[] args) {
        int size = 5;
        pattern(size);
    }

    public  static void pattern(int size) {
        for(int row=1;row<=size;row++) {
            for(int col=1;col<=size-row+1;col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}