/**
 * Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 *
 * Input Format
 * The first and only argument contains the string A, consisting of lowercase English alphabets.
 *
 *
 * Output Format
 * Return an integer containing the answer.
 *
 *
 * Example Input
 * Input 1:
 *
 *   "abobc"
 * Input 2:
 *
 *   "bobob"
 *
 *
 * Example Output
 * Output 1:
 *
 *   1
 * Output 2:
 *
 *   2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *   The only occurrence is at second position.
 * Explanation 2:
 *
 *   Bob occures at first and third position.
 */

package Strings;

public class CountOccurrences {
    public static void main(String[] args) {
        String string = "bobob";

        int res = solve(string);
        System.out.println(res);
    }
    public static int solve(String string) {

        // O(N) time | O(1) space
        int res = 0;

        for (int i = 0; i + 2 < string.length(); i++) {
            if (string.charAt(i) == 'b' &&
                    string.charAt(i + 1) == 'o' &&
                    string.charAt(i + 2) == 'b')
                ++res;
        }

//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//            StringBuilder sb = new StringBuilder();
//            sb.append(c);
//            for (int j = i + 1; j < string.length(); j++) {
//                sb.append(string.charAt(j));
//                if (sb.toString().equals("bob")) {
//                    res++;
//                }
//            }
//        }
        return res;
    }
}
