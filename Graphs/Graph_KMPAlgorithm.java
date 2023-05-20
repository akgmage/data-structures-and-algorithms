/*
 * KMP Algorithm for Pattern Searching  
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 * You may assume that n > m.
 * 
 * Examples:
 * 
 * Input:  txt[] = "THIS IS A TEST TEXT"
 *         pat[] = "TEST"
 * 
 * Output: Pattern found at index 10
 *  
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
