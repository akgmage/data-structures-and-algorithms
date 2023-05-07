// Check whether a string can be a valid palindrome by removing at most one character from it
'''
    Explanation:
    The function valid_palindrome takes a string s as input and returns a boolean indicating whether the 
    string can be a valid palindrome by removing at most one character from it.

    To check if the string can be a valid palindrome, we start by iterating over the string from both the 
    left and right ends at the same time. If we encounter two characters that are not the same, we need to 
    check if removing one of them would make the string a palindrome. We try removing the left character 
    first and create two new substrings - one with the left character removed and one with the right character removed.
    We then check if either of the substrings is a palindrome. If either of the substrings is a palindrome, 
    then the original string can be a palindrome by removing the corresponding character. If neither of 
    the substrings is a palindrome, then the original string cannot be a palindrome even by removing a character.

    If we have checked the whole string and haven't returned yet, it means that the original string is a palindrome.

    The time complexity of the given function is O(n), where n is the length of the input string. 
    This is because we are iterating through the string only once and performing constant-time operations.

    The space complexity of the function is also O(n), where n is the length of the input string. 
    This is because we are using a constant amount of extra space to keep track of the counts of characters. 
    The size of this extra space does not depend on the length of the input string.
'''
# using two-pointer Technique
def valid_palindrome(s: str) -> bool:
    left, right = 0, len(s) - 1
    
    # iterate over the string from left and right at the same time
    while left < right:
        # if the characters at the left and right indices are not the same
        if s[left] != s[right]:
            # we need to check if removing one of them makes the string a palindrome
            # we try removing the left character first
            left_removed = s[left:right]
            right_removed = s[left+1:right+1]
            # if either of the substrings after removal is a palindrome, then the original string is also a palindrome
            return left_removed == left_removed[::-1] or right_removed == right_removed[::-1]
        
        # move to the next pair of characters
        left += 1
        right -= 1
    
    # if we have checked the whole string and haven't returned yet, it's a palindrome
    return True
