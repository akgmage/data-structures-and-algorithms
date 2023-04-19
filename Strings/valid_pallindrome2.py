'''
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    Constraints: string.length The string only consists of English letters

    Sample Input : "madame"
    Output : True

    Sample Input : "masdasd"
    Output : False	
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
