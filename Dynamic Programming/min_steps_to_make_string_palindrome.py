'''
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
'''
# Function to calculate the length of the Longest Common Subsequence (LCS) of two strings
def lcs(s1, s2):
    n, m = len(s1), len(s2)
    
    # Create a 2D list dp to store the lengths of LCS
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    
    # Fill the dp array using dynamic programming
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if s1[i - 1] == s2[j - 1]:
                # If characters at the current positions match, increase the length of LCS by 1
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                # Take the maximum length from the previous positions
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    
    # Return the length of the LCS of s1 and s2
    return dp[n][m]

# Function to calculate the minimum number of insertions required to make a string palindrome
def min_insertions(s):
    reverse_s = s[::-1]  # Reverse the string s
    
    lcs_length = lcs(s, reverse_s)  # Find the length of the LCS of s and its reverse
    return len(s) - lcs_length  # Return the number of insertions required to make s a palindrome

if __name__ == "__main__":
    s = input()  # Read input string
    ans = min_insertions(s)  # Calculate the minimum number of insertions required
    print(ans)  # Print the result
