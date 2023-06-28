/*The code implements the dynamic programming approach to find the longest palindrome substring in a given string. It uses a two-dimensional table dp to store the results of subproblems, where dp[i][j] represents whether the substring from index i to index j is a palindrome.

The algorithm first checks for all substrings of length 1 and marks them as palindromes. Then it checks for substrings of length 2 and updates the start and maxLen variables if a palindrome of length 2 is found.

After that, it checks for substrings of length greater than 2 by iterating over all possible lengths and positions. If a palindrome is found at a particular position, it updates the start and maxLen variables accordingly.

*/

#include <string>
#include <vector>

class Solution {
public:
    /**
     * Finds the longest palindrome substring within a given string.
     *
     * @param s The input string.
     * @return The longest palindrome substring.
     */
    std::string longestPalindrome(std::string s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int start = 0;  // start index of the longest palindrome
        int maxLen = 1; // length of the longest palindrome

        // Initialize a table to store the results of subproblems
        std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        // Return the longest palindrome substring
        return s.substr(start, maxLen);
    }
};

