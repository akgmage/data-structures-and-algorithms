/**
 * Problem Description
 * Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 * Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
 *
 * Note:
 *
 * If there is no such window in A that covers all characters in B, return the empty string.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
 *
 *
 * Problem Constraints
 * 1 <= size(A), size(B) <= 106
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
 * Return a string denoting the minimum window.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "ADOBECODEBANC"
 *  B = "ABC"
 * Input 2:
 *
 *  A = "Aa91b"
 *  B = "ab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  "BANC"
 * Output 2:
 *
 *  "a91b"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  "BANC" is a substring of A which contains all characters of B.
 * Explanation 2:
 *
 *  "a91b" is the substring of A which contains all characters of B.
 */
package Strings;

import java.util.HashMap;

public class WindowString {
    public static void main(String[] args) {
        String a = "cabwefgewcwaefgcf";
        String b = "cae";

        String ans = solve(a, b);
        System.out.println(ans);
    }
    public static String solve(String a, String b) {
        // O(N) time | O(1) space

        if (a.length() < b.length()) return "";

        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            counts.put (b.charAt(i), counts.getOrDefault(b.charAt(i), 0) + 1);
        }

        //slide the window
        int start = 0;
        int length = 0;
        int total = 0;

        for (int head = 0, tail = 0; tail < a.length(); tail++) {
            if (counts.get(a.charAt(tail)) == null) {
                // if this character in 'a' is not present in b at all,
                // we don't care about this character.
                continue;
            }
            counts.put(a.charAt(tail), counts.get(a.charAt(tail)) - 1);
            // we check if the current character represented by tail caused
            // a character to be included which is relevant to b and is still
            // in deficit.
            // For example, if b has 3 A's, then the first 3 A's are relevant to us
            // but the 4th one is not.
            if (counts.get(a.charAt(tail)) >= 0) {
                total++;
            }
            // check if we have all character in b covered.
            if (total == b.length()) {
                // Now move the head pointer till popping out those characters
                // still makes sure that all characters in b are covered.
                while (counts.get(a.charAt(head)) == null || counts.get(a.charAt(head)) < 0) {
                    if (counts.get(a.charAt(head)) != null)
                        counts.put(a.charAt(head), counts.get(a.charAt(head)) + 1);
                    head++;
                }
                // Now [head - 1, tail] is valid substring. Update the answer.
                if (length == 0 || tail - head + 1 < length) {
                    length = tail - head + 1;
                    start = head;
                }
            }
        }
        return a.substring(start, start + length);
    }
}
