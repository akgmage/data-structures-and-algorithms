/*
   Given two strings str1 and str2 and following three operations that can performed on str1.
   1) Insert
   2) Remove
   3) Replace
   Find minimum number of operations required to convert ‘str1’ into ‘str2’.
   For example if input strings are CAT AND CAR the edit distance is 1.

   Input  :  s1 : saturday  s2 : sunday
   Output :  3
*/
// Dynamic Programming Solution : TC O(n^2)
package main

import (
	"fmt"
)

// findEditDistance finds the minimum edit distance between two strings.
func findEditDistance(s1, s2 string) int {
	l1, l2 := len(s1), len(s2)

	// Create a 2D array dp to store the edit distances.
	dp := make([][]int, l1+1)
	for i := range dp {
		dp[i] = make([]int, l2+1)
	}

	// Initialize the base cases for empty strings.
	for i := 0; i <= l1; i++ {
		dp[i][0] = i // Minimum edit distance for transforming s1[0...i] to an empty string.
	}
	for i := 0; i <= l2; i++ {
		dp[0][i] = i // Minimum edit distance for transforming an empty string to s2[0...i].
	}

	// Calculate the edit distance for the rest of the strings.
	for i := 1; i <= l1; i++ {
		for j := 1; j <= l2; j++ {
			if s1[i-1] == s2[j-1] {
				dp[i][j] = dp[i-1][j-1] // No edit required if characters match.
			} else {
				del := dp[i][j-1]      // Deletion (from s2).
				replace := dp[i-1][j-1] // Replacement (of s1[i] with s2[j]).
				insert := dp[i-1][j]   // Insertion (into s1).
				dp[i][j] = min(del, min(replace, insert)) + 1 // Choose the minimum of the three operations.
			}
		}
	}

	// Print the edit distance matrix (optional).
	for i := 0; i <= l1; i++ {
		for j := 0; j <= l2; j++ {
			fmt.Printf("%5d ", dp[i][j])
		}
		fmt.Println()
	}

	return dp[l1][l2] // Return the minimum edit distance.
}

func main() {
	s1 := "abhisek"
	s2 := "tsunade"

	result := findEditDistance(s1, s2)
	fmt.Printf("Minimum Edit Distance: %d\n", result)
}
