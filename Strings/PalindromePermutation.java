/**
 * Given a string s, return true if a permutation of the string could form a
 * palindrome
 *  and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "code"
 * Output: false
 * Example 2:
 *
 * Input: s = "aab"
 * Output: true
 * Example 3:
 *
 * Input: s = "carerac"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5000
 * s consists of only lowercase English letters.
 */
package Strings;

import java.util.Arrays;

public class PalindromePermutation {
    public static void main(String[] args) {
//        String s = "aab";
        String s = "aabb";

        boolean res = solve(s);
        System.out.println(res);
    }
    public static boolean solve(String s) {

        // O(N) time | O(1) space
       int[] charCounts = new int[128];
       for (int i = 0; i < s.length(); i++) {
           charCounts[s.charAt(i)]++;
       }

        System.out.println(Arrays.toString(charCounts));
       int count = 0;
       for (int i = 0; i < 128; i++) {
           count += charCounts[i] % 2;
       }

       return count <= 1;
    }
}
