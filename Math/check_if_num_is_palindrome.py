
class Solution:
    def isPalindrome(self, x: int) -> bool:
        #check if the number is less than zero.
        if(x<0):
            return False
        #Then, calculating the reverse of the number to see if it is equal to the original number.
        rev = 0
        original_value = x
        while x != 0:
            rev = rev * 10 + x % 10
            x = x// 10
        return rev == original_value