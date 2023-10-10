'''
	Given a string s, return the longest palindromic substring in s.

	Example 1:
	Input: s = "babad"
	Output: "bab"
	Explanation: "aba" is also a valid answer.

	Example 2:
	Input: s = "cbbd"
	Output: "bb"


	Constraints:
	1 <= s.length <= 1000
	s consist of only digits and English letters.
'''
def longest_palindromic_substring(Array):
    n = len(Array)

    # Create a 2D boolean array L to store whether substrings are palindromes.
    L = [[False] * n for _ in range(n)]

    max_length = 1  # Initialize the maximum palindrome length to 1 (single characters are palindromes)

    # Initialize the base cases for substrings of length 1 and 2.
    for i in range(n - 1):
        L[i][i] = True  # Single characters are palindromes
        if Array[i] == Array[i + 1]:
            L[i][i + 1] = True  # Check for palindromes of length 2
            max_length = 2  # Update the maximum palindrome length

    # Check for palindromes of length 3 and greater.
    for k in range(3, n + 1):
        for i in range(n - k + 1):
            j = i + k - 1

            # Check if the characters at the ends of the current substring match
            # and if the substring inside is a palindrome.
            if Array[i] == Array[j] and L[i + 1][j - 1]:
                L[i][j] = True  # Mark the current substring as a palindrome
                max_length = k  # Update the maximum palindrome length

    return max_length  # Return the length of the longest palindromic substring

# Example usage:
result = longest_palindromic_substring("babad")
print(result)  # Output: 3 ("bab" or "aba" is the longest palindromic substring)
