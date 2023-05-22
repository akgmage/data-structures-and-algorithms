/**
 * Summary:
 * This program implements the Knuth-Morris-Pratt (KMP) algorithm for string pattern matching.
 * Given a text string and a pattern string, the algorithm searches for the pattern in the text and returns
 * the index where the pattern is found in the text. If the pattern is not found, it returns -1.
 * 
 * Inputs:
 * The program expects two strings as inputs: text and pattern.
 * 
 * Outputs:
 * The output of the program is the index where the pattern is found in the text, or -1 if the pattern is not found.
 * 
 * Example Usage:
 * // Input
 * String text = "ABABDABACDABABCABAB";
 * String pattern = "ABABCABAB";
 * 
 * // Execute the KMP algorithm for string pattern matching
 * int index = searchPattern(text, pattern);
 * 
 * // Output
 * if (index != -1) {
 *     System.out.println("Pattern found at index: " + index);
 * } else {
 *     System.out.println("Pattern not found in the text.");
 * }
 * 
 * Complexity Analysis:
 * The time complexity of the KMP algorithm is O(n + m), where n is the length of the text and m is the length of the pattern.
 * This is because the algorithm avoids unnecessary comparisons by utilizing the computed Longest Proper Prefix-Suffix (LPS) array.
 * The space complexity is O(m) as it requires storing the LPS array of the pattern.
 */

public class Graph_KMPAlgorithm {

    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static int searchPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

        int i = 0;  // index for text
        int j = 0;  // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j;
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;  // pattern not found in text
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int index = searchPattern(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
