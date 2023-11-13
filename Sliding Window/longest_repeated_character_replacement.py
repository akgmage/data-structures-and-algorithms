'''
     You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    Summary:
    The provided code defines a Java class `Solution` with a method `characterReplacement` that aims to find the 
    longest substring within the input string `s` such that it can be created by replacing at most `k` characters 
    with any other character. It uses a sliding window approach to efficiently compute the maximum length of such a 
    substring.

    Time Complexity:
    - The code iterates through the input string `s` using a sliding window with two pointers 
    (startWindow and endWindow). During each iteration, it updates character counts and evaluates the 
    maximum length of a valid substring. Since each character is processed exactly once, the time complexity 
    is O(N), where N is the length of the input string `s`.

    Space Complexity:
    - The code uses additional space to store integer variables (`count`, `startWindow`, `maxCount`, and `max`). 
    The `count` array has a fixed size of 26 (for 26 English alphabet letters). Therefore, the space complexity is
     O(1), as the space used is constant and does not depend on the input size.

    In summary, the algorithm has a time complexity of O(N) and a space complexity of O(1), making it efficient 
    for finding the longest substring with at most 'k' replacements in a given string.
'''
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = [0] * 26  # Initialize a list to count the occurrences of characters (26 letters in the English alphabet)
        startWindow = 0  # The left end of the sliding window
        maxCount = 0     # The maximum count of any character within the window
        max_length = 0   # The maximum length of a substring that can be formed

        # Iterate through the string using a sliding window approach
        for endWindow in range(len(s)):
            val = ord(s[endWindow]) - ord('A')  # Convert the character to an index (0-25)
            count[val] += 1  # Increment the count for the current character
            maxCount = max(maxCount, count[val])  # Update the maximum character count

            # While the length of the current window minus the maximum character count exceeds 'k', shrink the window
            while endWindow - startWindow + 1 - maxCount > k:
                val = ord(s[startWindow]) - ord('A')  # Get the character at the start of the window
                count[val] -= 1  # Decrement the count for the character at the start of the window
                startWindow += 1  # Move the start of the window to the right

            # Update the maximum length of a substring that can be formed
            max_length = max(max_length, endWindow - startWindow + 1)

        # Return the maximum length, which represents the longest substring with at most 'k' replacements
        return max_length
