/*The function isPalindrome checks if a given substring of s is a palindrome. The minCut function utilizes dynamic programming to find the minimum cuts needed for each substring. It initializes a table cuts to store the minimum cuts for each position in the string. It also creates a palindrome table to check if a substring is a palindrome or not.

The algorithm iterates through the string s from left to right and checks all possible substrings to find palindromes. If a palindrome is found, it updates the cuts table based on the previous cuts. Finally, it returns the minimum cuts needed for the entire string.

In the main function, we provide an example string "aabba" and print the minimum cuts required. You can replace "aabba" with your own string to find its optimal partition.

Time Complexity:
The outer loop iterates through the string s once, and for each character, it checks all possible substrings. Therefore, the time complexity of the solution is O(n^2), where n is the length of the string.

Space Complexity:
The space complexity is determined by the two tables used: cuts and palindrome. Both tables have a size of n, where n is the length of the string s. Therefore, the space complexity is O(n).

Overall, the solution has a time complexity of O(n^2) and a space complexity of O(n).
*/




func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func isPalindrome(s string, i, j int) bool {
	for i < j {
		if s[i] != s[j] {
			return false
		}
		i++
		j--
	}
	return true
}

func minCut(s string) int {
	n := len(s)
	if n <= 1 {
		return 0
	}

	// Create a table to store the minimum cuts for each substring
	cuts := make([]int, n)
	palindrome := make([][]bool, n)

	for i := 0; i < n; i++ {
		palindrome[i] = make([]bool, n)
		cuts[i] = i
	}

	for j := 0; j < n; j++ {
		for i := 0; i <= j; i++ {
			if s[i] == s[j] && (j-i <= 1 || palindrome[i+1][j-1]) {
				palindrome[i][j] = true
				if i > 0 {
					cuts[j] = min(cuts[j], cuts[i-1]+1)
				} else {
					cuts[j] = 0
				}
			}
		}
	}

	return cuts[n-1]
}

func main() {
	s := "aabba"
	minimumCuts := minCut(s)
	fmt.Println("Minimum cuts:", minimumCuts)
}
