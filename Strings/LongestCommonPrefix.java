/**
 * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
 *
 * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 *
 *
 * Problem Constraints
 * 0 <= sum of length of all strings <= 1000000
 *
 *
 *
 * Input Format
 * The only argument given is an array of strings A.
 *
 *
 *
 * Output Format
 * Return the longest common prefix of all strings in A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = ["abcdefgh", "aefghijk", "abcefgh"]
 * Input 2:
 *
 * A = ["abab", "ab", "abcd"];
 *
 *
 * Example Output
 * Output 1:
 *
 * "a"
 * Output 2:
 *
 * "ab"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Longest common prefix of all the strings is "a".
 * Explanation 2:
 *
 * Longest common prefix of all the strings is "ab".
 */
package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"ab", "abab", "ab", "abcd"};

        String res = solve(strings);
        System.out.println(res);
    }
    public static String solve(String[] strings) {
        if (strings == null || strings.length == 0) return "";

        for (int i = 0; i < strings[0].length(); i++) {
            char currentChar = strings[0].charAt(i);

            for (int j = 1; j < strings.length; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != currentChar)
                        return strings[0].substring(0, i);
            }
        }
        return strings[0];
    }
}
