/* 
Issue#415
//Input:
Given a string s, return the longest palindromic substring in s.

//Palindrome:A palindrome is a word, phrase, or sequence that reads the same forward and backward, like "level" or "A man, a plan, a canal, Panama."

//Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
//Example 2:
Input: s = "cbbd"
Output: "bb"

//Time complexity:
>>Time Complexity: O(n2)
as there is two recursion calls which are applied as two pointers so here Complexity would be O(n2).
>>Space Complexity: O(n) which is nothing but the storage consumed in this process.

//Explanation:
>>The function first converts the input string into a character array. 
>>If the length of the string is less than 2, it means the string itself is a palindrome, so it returns the string as is.
>>The function then iterates through each character of the string.
>>For each character, it expands outwards from that character and checks if it forms a palindrome. 
>>It does this by calling the expandPalindrome function twice: once for odd-length palindromes with the current character as the center,
and once for even-length palindromes with the current character and the next character as centers.
>>The expandPalindrome function checks if the characters at positions j and k are equal, and if so, it expands the palindrome by decrementing j and incrementing k.
>>It continues this process until the characters at positions j and k are no longer equal or reach the boundaries of the string.
>>If a longer palindrome is found, the maxLen and lo variables are updated accordingly.
maxLen stores the length of the longest palindrome found so far, and lo stores the starting position of the longest palindrome.
>>Finally, the function returns the substring of the original string from the starting position lo to lo + maxLen, which represents the longest palindrome found.

*/
class Solution {
    int maxLen = 0;  // Length of the longest palindrome
    int lo = 0;     // Starting position of the longest palindrome

    public String longestPalindrome(String s) {
        char[] input = s.toCharArray(); // Convert the input word to individual characters

        if (s.length() < 2) {
            return s;   // If word has less than 2 letters, it is already a palindrome
        }

        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);      // Check odd-length palindromes with current letter as center
            expandPalindrome(input, i, i + 1);  // Check even-length palindromes with current and next letters as center
        }
        return s.substring(lo, lo + maxLen);    // Return the longest palindrome found
    }

    public void expandPalindrome(char[] s, int j, int k) {
        while (j >= 0 && k < s.length && s[j] == s[k]) {
            j--;    // Move left to expand potential palindrome
            k++;    // Move right to expand potential palindrome
        }
        if (maxLen < k - j - 1) {
            maxLen = k - j - 1; // Update length of longest palindrome if longer one is found
            lo = j + 1;         // Update starting position of longest palindrome
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "babad";
        String longestPalindrome = solution.longestPalindrome(input);
        System.out.println("Longest Palindrome: " + longestPalindrome);
    }
}



