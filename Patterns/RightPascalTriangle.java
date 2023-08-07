/*
    Right Pascal Triangle pattern in java
    Approach:
        1) Identify the numbers of rows for the outer for loop
        2) Identify the relation of column with respect to row.
            In this case col = size-row+1
        3) for each loop , print the respective element.

    TIME COMPLEXITY: O(N^2)
    SPACE COMPLEXITY: O(1)
     Eg: For size = 5,
        OUTPUT:
                * 
                * * 
                * * * 
                * * * * 
                * * * 
                * * 
                *
 */
public class RightPascalTriangle {

    public static void main(String[] args) {
        int size = 4;
        pattern(size);
    }

    public static void pattern(int size) {
        for(int row=0;row< 2*size-1;row++){
            int totalcol = row < size?row:2*size-row-2;
            for(int col =0;col <=totalcol;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

