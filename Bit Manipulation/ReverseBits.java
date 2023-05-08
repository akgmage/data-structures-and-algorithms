/**
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  0
 * Input 2:
 *
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 */

package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
         long num = 3;
         long res = solve(num);
         System.out.println(res);
    }
    public static long solve(long n) {
        // O(1) time | O(1) space
        long res = 0;
        int i = 0;

        while (i < 32) {
            if ( ( (n >> i) & 1) == 1)
                    res += (long) Math.pow(2, 31 - i);
            i++;
        }
        return res;
    }
}
