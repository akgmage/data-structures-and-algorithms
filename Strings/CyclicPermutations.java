/**
 * Problem Description
 * Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
 *
 * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ length(A) = length(B) ≤ 105
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the required answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "1001"
 *  B = "0011"
 * Input 2:
 *
 *  A = "111"
 *  B = "111"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".
 *  There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
 * Explanation 2:
 *
 *  All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
package Strings;

import java.util.Arrays;

public class CyclicPermutations {
    public static void main(String[] args) {
        String A = "1001";
        String B = "0011";

        int ans = solve(A, B);
        System.out.println(ans);
    }
    public static int solve(String substring, String string) {
        // O(N+M) time | O(M) space
        int[] lps = computeLPS(substring);
        System.out.println(Arrays.toString(lps));
        string += string; // append string to tackle cyclic permutations

        int i = 0, j = 0, ans = 0;
        int n = string.length();
        int m = substring.length();

        while (i < n - 1) { // go to only n - 1 index
            if (string.charAt(i) == substring.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                j = lps[j - 1];
                ans++;
            } else if (i < n && string.charAt(i) != substring.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
    public static int[] computeLPS(String s) {
        int m = s.length();
        int[] lps = new int[m];
        // lps[i] finds the longest proper prefix of s[0...i]
        // which is also a suffix of s[0...i]
        lps[0] = 0;
        int j = 0, i = 1;
        while (i < m) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
