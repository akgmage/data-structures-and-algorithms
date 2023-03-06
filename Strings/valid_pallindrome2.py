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
    
    while left < right:
        if s[left] != s[right]:
            # Check if deleting either left or right char will create a palindrome
            return is_palindrome(s, left + 1, right) or is_palindrome(s, left, right - 1)
        left += 1
        right -= 1
        
    return True

def is_palindrome(s: str, left: int, right: int) -> bool:
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True

print(valid_palindrome("aba")) # True
print(valid_palindrome("abca")) # True
print(valid_palindrome("abc")) # False