'''
    Given an integer x, return true if x is a 
    palindrome
    , and false otherwise.

    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.
    
    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    
    Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Constraints:
    -231 <= x <= 231 - 1

    Follow up: Could you solve it without converting the integer to a string?
'''
class Solution:
    def isPalindrome(self, x: int) -> bool:
        #check if the number is less than zero.
        if x < 0:
            return False
        #Then, calculating the reverse of the number to see if it is equal to the original number.
        rev = 0
        original_value = x
        while x != 0:
            rev = rev * 10 + x % 10
            x = x // 10
        return rev == original_value