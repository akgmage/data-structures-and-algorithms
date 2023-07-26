function minInsertionStepsToPalindrome(str) {
  const n = str.length;
  // Create a 2D array to store the minimum steps needed to make substrings palindrome
  const dp = Array.from({ length: n }, () => Array(n).fill(0));

  // Base case: single characters are palindromes, so dp[i][i] = 0
  for (let i = 0; i < n; i++) {
    dp[i][i] = 0;
  }

  // Fill the dp table in bottom-up manner
  for (let len = 2; len <= n; len++) {
    for (let i = 0; i < n - len + 1; i++) {
      const j = i + len - 1;
      if (str[i] === str[j]) {
        // If the characters at the ends are the same, no additional insertion is needed
        dp[i][j] = dp[i + 1][j - 1];
      } else {
        // Otherwise, choose the minimum between inserting character at i or j
        dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
      }
    }
  }

  return dp[0][n - 1];
}

// Example usage:
const str = "abcd";
const minInsertions = minInsertionStepsToPalindrome(str);
console.log("Minimum insertion steps:", minInsertions); // Output: 3 (abcd -> dabcbad)
