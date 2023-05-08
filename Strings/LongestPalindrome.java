/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is
 *
 */
package Strings;

public class LongestPalindrome {
    public static void main(String[] args) {
        String string = "abccccdd";

        int res = solve(string);
        System.out.println(res);
    }
    public static int solve(String string) {
        // O(N) time | O(1) space

        /**
         * Reference : ChatGPT
         * For the letters with even count, you can add their count to the total length
         * of the palindrome. For the letters with odd count, you can add their count - 1
         * to the total length, and add 1 to the final length if there is only one letter
         * with an odd count. This is because a palindrome can have at most one letter in
         * the middle with an odd count.
         */

        int[] letterCounts = new int[128];

        for (char c : string.toCharArray()) {
            letterCounts[c]++;
        }

        int length = 0;
        boolean hasOdd = false;
        for (int count : letterCounts) {
            if (count % 2 == 0)
                length += count;
            else {
                length += count - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) length += 1;
        return length;
    }
}
