/**
 * You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
 *
 * You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * A[i] ∈ ['a'-'z', 'A'-'Z']
 *
 *
 *
 * Input Format
 *
 * First and only argument is a character string A.
 *
 *
 *
 * Output Format
 *
 * Return a character string.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "Hello"
 * Input 2:
 *
 *  A = "tHiSiSaStRiNg"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  hELLO
 * Input 2:
 *
 *  ThIsIsAsTrInG
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  'H' changes to 'h'
 *  'e' changes to 'E'
 *  'l' changes to 'L'
 *  'l' changes to 'L'
 *  'o' changes to 'O'
 * Explanation 2:
 *
 *  "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
 */

package Strings;

public class ToggleCase {
    public static void main(String[] args) {
        String string = "tHiSiSaStRiNg";

        String res = solve(string);
        System.out.println(res);
    }

    public static String solve (String string) {
//        O(N) time | O(N) space where N is the length of the string

       StringBuilder res = new StringBuilder();
        int len = string.length();

        for (int i = 0; i < len; i++) {
            char currentChar = string.charAt(i);
            int currentCharASCII = currentChar;

            if (currentChar >= 'a' && currentChar <= 'z')
                currentCharASCII -= 32;
            else currentCharASCII += 32;

            res.append((char) currentCharASCII);

        }
        return String.valueOf(res);
    }
}
