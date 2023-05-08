/**
 * Problem Description
 * Given two binary strings A and B. Return their sum (also a binary string).
 *
 *
 * Problem Constraints
 * 1 <= length of A <= 105
 *
 * 1 <= length of B <= 105
 *
 * A and B are binary strings
 *
 *
 *
 * Input Format
 * The two argument A and B are binary strings.
 *
 *
 *
 * Output Format
 * Return a binary string denoting the sum of A and B
 *
 *
 *
 * Example Input
 * Input 1:
 * A = "100"
 * B = "11"
 * Input 2:
 * A = "110"
 * B = "10"
 *
 *
 * Example Output
 * Output 1:
 * "111"
 * Output 2:
 * "1000"
 *
 *
 * Example Explanation
 * For Input 1:
 * The sum of 100 and 11 is 111.
 * For Input 2:
 *
 * The sum of 110 and 10 is 1000.
 */

package Strings;

import com.google.common.base.Stopwatch;

public class AddBinaryStrings {
    public static void main(String[] args) {
        Stopwatch timer = Stopwatch.createStarted();
        String str1 = "11";
        String str2 = "1";

        String res = solve(str1, str2);
        System.out.println(res);
        System.out.println("Runtime " + timer.stop());
    }
    public static String solve(String str1, String str2) {

        // O(N+M) time |O(N+M)
        StringBuilder stringBuilder = new StringBuilder();
        int i = str1.length() - 1, j = str2.length() - 1,
        carry = 0;

        while (i > -1 || j > -1) {
            int sum = carry;
            if (i >- 1) sum += str1.charAt(i) - '0'; // To convert to number subtract with 0
            if (j > -1) sum += str2.charAt(j) - '0';
            stringBuilder.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry != 0) stringBuilder.append(carry);

        return stringBuilder.reverse().toString();
    }
}
