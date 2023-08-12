/*
    pattern to print:
for input:5
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *

    APPROACH:
        1) Identify the numbers of rows for the outer for loop
        2) Identify the relation of column with respect to row.
        3) for each loop , print the respective element.
 */
public class CompleteSquare {

    public static void main(String[] args) {
        int size = 5;
        for(int row=1;row <= size;row++) {
            for (int col = 1;col<=size;col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

