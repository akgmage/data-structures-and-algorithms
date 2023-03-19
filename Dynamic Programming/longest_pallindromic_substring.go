package main

import (
	"fmt"
)

func LongestPalindromicSubstring(Array string) int {
	n := len(Array)
	L := make([][]bool, n)
	for i := range L {
		L[i] = make([]bool, n) // defaults to false
	}
	max := 1
	for i := 0; i < n-1; i++ {
		L[i][i] = true
		if Array[i] == Array[i+1] {
			L[i][i+1] = true
			max = 2
		}
	}
	for k := 3; k <= n; k++ {
		for i := 1; i < n-k+1; i++ {
			j := i + k - 1
			if Array[i] == Array[j] && L[i+1][j-1] {
				L[i][j] = true
				max = k
			} else {
				L[i][j] = false
			}
		}
	}
	return max
}

func main() {
	fmt.Print(LongestPalindromicSubstring("babad"))

}