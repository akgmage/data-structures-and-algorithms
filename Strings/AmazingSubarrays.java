package Strings;

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
 * Constraints
 *
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 *     Amazing substrings of given string are :
 *     1. A
 *     2. AB
 *     3. ABE
 *     4. ABEC
 *     5. E
 *     6. EC
 *     here number of substrings are 6 and 6 % 10003 = 6.
 */

public class AmazingSubarrays {

    public static void main(String[] args) {
        String str = "ABEC";
        System.out.println(solve(str));
    }
    public static int solve(String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == 'a' ||
                currentChar == 'e' ||
                    currentChar == 'i' ||
                    currentChar == 'o' ||
                    currentChar == 'u' ||
                    currentChar == 'A' ||
                    currentChar == 'E' ||
                    currentChar == 'I' ||
                    currentChar =='O' ||
                    currentChar == 'U') {
                System.out.println(str.length() - i);
                ans += str.length() - i;
            }
        }
        return ans;
    }
}
