/**
 * Problem Description
 * Given two strings A and B, determine if they are isomorphic.
 *
 * A and B are called isomorphic strings if all occurrences of each character in A can be replaced with another character to get B and vice-versa.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= |B| <= 100000
 *
 * A and B contain only lowercase characters.
 *
 *
 *
 * Input Format
 * The first Argument is string A.
 *
 * The second Argument is string B.
 *
 *
 *
 * Output Format
 * Return 1 if strings are isomorphic, 0 otherwise.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "aba"
 * B = "xyx"
 * Input 2:
 *
 * A = "cvv"
 * B = "xyx"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Replace 'a' with 'x', 'b' with 'y'.
 * Explanation 2:
 *
 *  A cannot be converted to B.
 */

package Strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "vc";
        String t = "aa";

        boolean ans = solve(s, t);
        System.out.println(ans);
    }
    public static boolean solve(String s, String t) {
        // O(N) time | O(N) space
        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (!hm.containsKey(s.charAt(i))) {
                if (hm.containsValue(t.charAt(i))) return false;
                hm.put (s.charAt(i), t.charAt(i));
            }
            else {
                if (hm.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }

        return true;
    }
}
