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

package main

import (
	"fmt"
)

func lcs(s1, s2 string) int {
	n, m := len(s1), len(s2)
	dp := make([][]int, n+1) // Create a 2D matrix dp to store the lengths of LCS
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m+1)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if s1[i-1] == s2[j-1] { // If characters at the current positions match
				dp[i][j] = 1 + dp[i-1][j-1] // Increase the length of LCS by 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1]) // Take the maximum length from the previous positions
			}
		}
	}

	return dp[n][m] // Return the length of the LCS of s1 and s2
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func minInsertions(s string) int {
	reverseS := ""
	for i := len(s) - 1; i >= 0; i-- {
		reverseS += string(s[i]) // Reverse the string s
	}

	lcsLength := lcs(s, reverseS) // Find the length of the LCS of s and its reverse
	return len(s) - lcsLength // Return the number of insertions required to make s a palindrome
}

func main() {
	var s string
	fmt.Scanln(&s) // Read input string
	ans := minInsertions(s) // Calculate the minimum number of insertions required
	fmt.Println(ans) // Print the result
}
