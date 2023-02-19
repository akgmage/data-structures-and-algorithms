/**
 * Problem Description
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * 0 <= B <= min(2A - 1 - 1 , 1018)
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

public class KthSymbolHard {
    public static void main(String[] args) {
        int n = 2;
        int k = 1;

        int ans = solve(n, k);
        System.out.println(ans);
    }
    public static int solve(int n, int k) {
        //O(N) time | O(N) space

        //Root Node
        if (n == 1) return 0;

        //Even Index
        if (k%2 == 0)
            return solve(n-1,k/2);

        //Odd Index
        return 1-solve(n-1,k/2);
    }
}
