/*
   DIAMOND PATTERN
      *
     * *
    * * *
   * * * *
    * * *
     * *
      *
      
   APPROACH:
        1) Identify the numbers of rows for the outer for loop
        2) Identify the relation of column with respect to row.
        3) for each loop , print the respective element.
 */
public class StarDiamond {

    public static void main(String[] args) {
        int size = 5;
        pattern(size);
    }

    public static void pattern(int size) {
        for (int row=1;row< 2*size;row++) {
            int totalcolsinrow = row <= size ? row:2*size-row;
            int spaces = size-totalcolsinrow;

            for(int i =1;i<=spaces;i++) {
                System.out.print(" ");
            }
            for(int col =1;col<=totalcolsinrow;col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

