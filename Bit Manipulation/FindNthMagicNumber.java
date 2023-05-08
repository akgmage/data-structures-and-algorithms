/**
 * roblem Description
 * Given an integer A, find and return the Ath magic number.
 *
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 *
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 5000
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the Ath magic number.
 *
 *
 *
 * Example Input
 * Example Input 1:
 *
 *  A = 3
 * Example Input 2:
 *
 *  A = 10
 *
 *
 * Example Output
 * Example Output 1:
 *
 *  30
 * Example Output 2:
 *
 *  650
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 *  3rd element in this is 30
 * Explanation 2:
 *
 *  In the sequence shown in explanation 1, 10th element will be 650.
 */

package BitManipulation;

public class FindNthMagicNumber {
    public static void main(String[] args) {
        int a = 2;
        int res = solve(a);
        System.out.println(res);
    }
    public static int solve(int a) {
        // O(N) time | O(1) space
        int res = 0, i = 1, currentNum = a;
        while (currentNum != 0) {
            if ( (currentNum & 1) == 1)
                res = res + (int) Math.pow(5, i);
            i++;
            currentNum = currentNum >> 1;
        }
        return res;
    }
}
