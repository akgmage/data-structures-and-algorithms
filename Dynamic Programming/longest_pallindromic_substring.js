/*
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
*/
function longestPalindromicSubstring(Array) {
  const n = Array.length;

  // Create a 2D boolean array L to store whether substrings are palindromes.
  const L = Array.from({ length: n }, () => Array(n).fill(false));

  let max_length = 1; // Initialize the maximum palindrome length to 1 (single characters are palindromes)

  // Initialize the base cases for substrings of length 1 and 2.
  for (let i = 0; i < n - 1; i++) {
    L[i][i] = true; // Single characters are palindromes
    if (Array[i] === Array[i + 1]) {
      L[i][i + 1] = true; // Check for palindromes of length 2
      max_length = 2; // Update the maximum palindrome length
    }
  }

  // Check for palindromes of length 3 and greater.
  for (let k = 3; k <= n; k++) {
    for (let i = 0; i < n - k + 1; i++) {
      const j = i + k - 1;

      // Check if the characters at the ends of the current substring match
      // and if the substring inside is a palindrome.
      if (Array[i] === Array[j] && L[i + 1][j - 1]) {
        L[i][j] = true; // Mark the current substring as a palindrome
        max_length = k; // Update the maximum palindrome length
      }
    }
  }

  return max_length; // Return the length of the longest palindromic substring
}

// Example usage:
const result = longestPalindromicSubstring("babad");
console.log(result); // Output: 3 ("bab" or "aba" is the longest palindromic substring)
