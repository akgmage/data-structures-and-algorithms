/**
 * Problem Description
 * You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
 *
 * Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 *
 *
 * Input Format
 * First and only argument is a string A of length N.
 *
 *
 *
 * Output Format
 * Return an integer, denoting the period of the string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abababab"
 * Input 2:
 *
 *  A = "aaaa"
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Period of the string will be 2:
 *  Since, for all i, A[i] = A[i%2].
 * Explanation 2:
 *
 *  Period of the string will be 1.
 */
package Strings;

public class PeriodOfAString {
    public static void main(String[] args) {
        String string = "abababab";

        int ans = solve(string);
        System.out.println(ans);
    }
    public static int solve(String string) {
        // O(N+M) time | O(N) space

//        BRUTE FORCE O(N*N) time | O(1) space
//        for (int k = 1; k < string.length(); k++) {
//            for (int i = 0; i < string.length(); i++) {
//                if (string.charAt(i) != string.charAt(i % k)) {
//                    break;
//                }
//                if (i == string.length() - 1) return k;
//            }
//        }
//        return string.length();

        int[] z = getZArray(string);

        for (int i = 1; i < string.length(); i++) {
            if (i + z[i] == string.length()) return i;
        }
        return string.length();
    }
    public static int[] getZArray(String string) {
        char[] input = string.toCharArray();
        int[] z = new int[string.length()];
        int n = string.length();

        int left = 0, right = 0; // maintain the segment

        for (int i = 1; i < n; i++) {
            int j = i, k = 0;
            if (i > right) { // outside the segment
                while (j < n && input[k] == input[j]) {
                    k++;
                    j++;
                }
                z[i] = k;
                left = i; right = j - 1;  // update the segment
            } else { // element is lying in the segment
                if (z[i - left] < right - j + 1) {
                    // trust and copy the answer
                    z[i] = z[i - left];
                } else {
                    // apply brute force
                    j = right + 1; k = right - i + 1;
                    while (j < n && input[j] == input[k]) {
                        k++;
                        j++;
                    }
                    z[i] = k;
                    left = i; right = j - 1;
                }
            }
        }
        return z;
    }

}
