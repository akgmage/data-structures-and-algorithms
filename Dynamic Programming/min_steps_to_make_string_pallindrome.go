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
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m+1)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if s1[i-1] == s2[j-1] {
				dp[i][j] = 1 + dp[i-1][j-1]
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[n][m]
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
		reverseS += string(s[i])
	}

	lcsLength := lcs(s, reverseS)
	return len(s) - lcsLength
}

func main() {
	var s string
	fmt.Scanln(&s)
	ans := minInsertions(s)
	fmt.Println(ans)
}
