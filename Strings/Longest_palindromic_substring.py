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
class Solution:
    #Instead of checking if a value is palindrome from the end, we can consider each index to be the center
    #Then, Check if the left and right indexed values to it are different.
    #The edge case would to find even lengthed palindrome like the second example
    #Reference: https://www.youtube.com/watch?v=XYQecbcd6_c

    def __init__(self):
        self.max_length = -1
        self.max_palindrome = ""
    def CheckLeftRight(self, s, index, value):
        low, high = index, index
        if(value == "even"):
            high = index + 1
        while(low >= 0 and high < len(s) and s[low] == s[high]):
            if(high - low + 1 > self.max_length):
                self.max_length = high - low + 1
                self.max_palindrome = s[low:high + 1]
            low -= 1
            high += 1

    def longestPalindrome(self, s: str) -> str:
        for i in range(len(s)):
            #odd values
            Solution.CheckLeftRight(self, s, i, "odd")
            #Even values
            Solution.CheckLeftRight(self, s, i, "even")
        return self.max_palindrome