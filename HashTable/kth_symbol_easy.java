/**
 * Problem Description
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 20
 *
 * 0 <= B < 2A - 1
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the Bth indexed symbol in row A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 *  B = 0
 * Input 2:
 *
 *  A = 4
 *  B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 * Explanation 2:
 *
 *  Row 1: 0
 *  Row 2: 01
 *  Row 3: 0110
 *  Row 4: 01101001
 */
package Hashing;

public class KthSymbolEasy {
    public static void main(String[] args) {
        int row = 3;
        int index = 0;
        String prev = "0";
        int res = solve(row, index, 1, prev);
        System.out.println(res);
    }
    public static int solve(int row, int index, int currentRow, String prev) {
            if (currentRow == row) return prev.charAt(index) - '0';
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < prev.length(); i++) {
                if (prev.charAt(i) == '0') str.append("01");
                else str.append("10");
            }
            return solve(row, index, currentRow + 1, str.toString());
    }
}
