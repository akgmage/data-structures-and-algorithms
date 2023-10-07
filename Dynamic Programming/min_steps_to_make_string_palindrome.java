/*
    Given a string, find the minimum number of insertions needed to make it a palindrome.

    Sample Input: "abcde"
    Sample Output: 4
    Explanation: The minimum insertions required are 'edcb' -> "abcdecb", resulting in a palindrome.

    Approach:
    We can solve this problem using dynamic programming.
    Let's define a 2D table, dp, where dp[i][j] represents the minimum number of insertions needed to make the substring from index i to j a palindrome.
    If the characters at indices i and j are equal, then dp[i][j] = dp[i+1][j-1].
    Otherwise, we have two options:
        1. Insert the character at index i at the end, i.e., dp[i][j] = dp[i][j-1] + 1.
        2. Insert the character at index j at the beginning, i.e., dp[i][j] = dp[i+1][j] + 1.
    We take the minimum of these two options as the minimum number of insertions required for the substring from index i to j.
    Finally, the minimum number of insertions needed for the entire string is dp[0][n-1], where n is the length of the string.

    Time complexity: O(n^2)
    Space complexity: O(n^2)
*/
import java.util.Scanner;

public class Main {
    
    // Function to calculate the length of the Longest Common Subsequence (LCS) of two strings
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // Create a 2D array dp to store the lengths of LCS
        int[][] dp = new int[n+1][m+1];
        
        // Initialize the first row and first column to 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    // If characters at the current positions match, increase the length of LCS by 1
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    // Take the maximum length from the previous positions
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // Return the length of the LCS of s1 and s2
        return dp[n][m];
    }

    // Function to calculate the minimum number of insertions required to make a string palindrome
    public static int minInsertions(String s) {
        StringBuilder reverseSb = new StringBuilder(s);
        reverseSb.reverse(); // Reverse the string s
        String reverseS = reverseSb.toString();

        int lcsLength = lcs(s, reverseS); // Find the length of the LCS of s and its reverse
        return s.length() - lcsLength; // Return the number of insertions required to make s a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Read input string
        int ans = minInsertions(s); // Calculate the minimum number of insertions required
        System.out.println(ans); // Print the result
        scanner.close();
    }
}
