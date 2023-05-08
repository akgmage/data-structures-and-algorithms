/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
package Strings;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";

        boolean ans = solve(s1, s2);
        System.out.println(ans);
    }
    public static boolean solve (String s1, String s2) {
        // O(N) time | O(1) space
        if (s2.length() < s1.length()) return false;

        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < len1; i++) {
            hash1[s1.charAt(i) - 'a'] += 1;
            hash2[s2.charAt(i) - 'a'] += 1;
        }

        if (check(hash1, hash2)) return true;

        for (int i = len1, j = 0; j < len2; i++, j++) {
            hash2[s2.charAt(j) - 'a'] -= 1;
            hash2[s2.charAt(i) - 'a'] += 1;

            if (check(hash1, hash2)) return true;
        }

        return false;
    }

    public static boolean check(int[] hash1, int[] hash2) {
        for (int i = 0; i < 26; i++) {
            if (hash1[i] != hash2[i]) return false;
        }
        return true;
    }
}
