/**
 * Problem Description
 * Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
 *
 * Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 *
 *
 * Input Format
 * The only argument given is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abc"
 * Input 2:
 *
 *  A = "bb"
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Insert 'b' at beginning, string becomes: "babc".
 *  Insert 'c' at beginning, string becomes: "cbabc".
 * Explanation 2:
 *
 *  There is no need to insert any character at the beginning as the string is already a palindrome.
 */
package Strings;

import java.util.Arrays;

public class MakeStringPalindrome {
    public static void main(String[] args) {
        String string = "bababaa";
        int ans = solve(string);
        System.out.println(ans);
    }
    public static int solve(String str) {

        String s = new String(str);
        StringBuilder sb = new StringBuilder(s);
        s = s + sb.reverse();
        System.out.println(s);
        int[] lps = computeLPS(s);
        System.out.println(Arrays.toString(lps));

        return Math.max (str.length() - lps[s.length() - 1], 0);
    }
    public static int[] computeLPS(String s) {
        int m = s.length();
        int[] lps = new int[m];
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
