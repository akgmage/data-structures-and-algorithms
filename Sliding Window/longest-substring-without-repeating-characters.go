package main

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
// Approach 1 Brute force
// Intuition
// Check all the substring one by one to see if it has no duplicate character.
// Time complexity O(n³ ) Space complexity O(m) where m is size of hMap
func LengthOfLongestSubstring1(s string) int {
    n := len(s)
    res := 0
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            if check(s, i, j) {
                res = max(res, j - i + 1)
            }
        }
    }
    return res
}
func max(a, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}
func check(s string, start int, end int) bool {
    hMap := [128]int{}
    for i := start; i <= end; i++ {
        hMap[s[i]]++
        if hMap[s[i]] > 1 {
            return false
        }
    }
    return true
}

// Approach 2:  Sliding window
// Time complexity O(n) Space complexity O(m) where m is size of char 
func LengthOfLongestSubstring2(s string) int {
    result := 0
    for i := 0; i < len(s); i++ {
        char := make(map[byte]bool)
        char[s[i]] = true
        for j := i + 1; j < len(s); j++ {
            if _, ok := char[s[j]]; ok {
                break
            }
            char[s[j]] = true
        }
        if len(char) > result {
            result = len(char)
        }
    }
    return result
}