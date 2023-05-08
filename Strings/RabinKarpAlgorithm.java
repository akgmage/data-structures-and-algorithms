/**
 * Problem Description
 * Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.
 *
 *
 * Problem Constraints
 * 1 <= M <= N <= 105
 *
 *
 *
 * Input Format
 * Two argument A and B are strings
 *
 *
 * Output Format
 * Return an integer denoting the number of occurrences of B in A
 *
 *
 * Example Input
 * Input 1:
 * A = "acbac"
 * B = "ac"
 * Input 2:
 * A = "aaaa"
 * B = "aa"
 *
 *
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 3
 *
 *
 * Example Explanation
 * For Input 1:
 * The string "ac" occurs twice in "acbac".
 * For Input 2:
 * The string "aa" occurs thrice in "aaaa".
 */
package Strings;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        String string = "1001";
        String pattern = "0011";

        int ans = solve(string, pattern);
        System.out.println(ans);
    }

    public static int solve(String string, String patternString) {
        // O(N) time | O(N) space
        char[] input = string.toCharArray(); // convert input string to character array
        char[] pattern = patternString.toCharArray(); // convert pattern string to character array
        int inputLength = input.length;
        int patternLength = pattern.length;
        int count = 0; // count the patterns
        long inputHash = 0; // input hash
        long patternHash = 0; // pattern hash
        long powerFirst = 1;
        int mod = (int) 1e9 + 7;
        int base = 26;

        // calculate the first window

        for (int i = 0; i < patternLength; i++) {
            patternHash = ((patternHash * base) % mod + pattern[i]) % mod;
            inputHash = ((inputHash * base) % mod + input[i]) % mod;
        }

        if (patternHash == inputHash) count++;

        for (int i = 0; i < patternLength - 1; i++) {
            powerFirst = (powerFirst * base) % mod;
        }

        for (int i = 0; i < inputLength - patternLength; i++) {

            // remove ith and i+1'th
           inputHash = ( (base * (inputHash - (powerFirst * input[i]) % mod)) % mod + input[i + patternLength]) % mod;
           if (inputHash < 0) {
               inputHash = (inputHash + mod);
           }

           if (patternHash == inputHash) {
               count++;
           }

        }
        return count;
    }
}
