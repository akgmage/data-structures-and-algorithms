'''
Given a string, find the length of the longest substring in it with no more than K distinct characters.

'''
def longestSubstringWithKDistinctChars(s, k):
    # Check for edge cases where s is empty, or k is 0.
    if not s or k == 0:
        return 0

    start_window = 0           # Initialize the start of the sliding window.
    max_len = 0                # Initialize the maximum length of the substring.
    char_count = {}            # Create a dictionary to store character frequencies.

    for end_window in range(len(s)):
        right = s[end_window]    # Get the character at the end of the window.
        char_count[right] = char_count.get(right, 0) + 1  # Update the character count in the dictionary.

        # While there are more than k distinct characters in the window.
        while len(char_count) > k:
            left = s[start_window]   # Get the character at the start of the window.
            char_count[left] -= 1    # Decrease the count of the character.
            if char_count[left] == 0:
                del char_count[left]  # If the count becomes 0, remove the character from the dictionary.
            start_window += 1        # Move the start of the window to the right.

        max_len = max(max_len, end_window - start_window + 1)  # Update the maximum length.

    return max_len

def max(a, b):
    if a > b:
        return a
    return b

if __name__ == "__main__":
    print(longestSubstringWithKDistinctChars("araaci", 2))
    print(longestSubstringWithKDistinctChars("araaci", 1))
    print(longestSubstringWithKDistinctChars("cbbebi", 3))
