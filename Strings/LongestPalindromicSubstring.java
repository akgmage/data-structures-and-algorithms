/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

package Strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String string = "abaxyzzyxf";

        String res = solve(string);
        System.out.println(res);
    }
    public static String solve(String string) {
        // O(N^2) time | O(1) space - where N is the length of string
        int[] longest = {0, 1};

        for (int i = 1; i < string.length(); i++) {
            int[] odd = getLongestPalindromeFrom(string, i - 1, i + 1);
            int[] even  = getLongestPalindromeFrom(string, i - 1, i);
            int[] currentLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest;
        }
        return string.substring(longest[0], longest[1]);
    }
    public static int[] getLongestPalindromeFrom(String string, int leftIdx, int rightIdx) {

        while (leftIdx > -1 && rightIdx < string.length()) {
            if (string.charAt(leftIdx) != string.charAt(rightIdx)) break;
            --leftIdx;
            ++rightIdx;
        }
            return new int[] {leftIdx + 1, rightIdx};
    }
}
