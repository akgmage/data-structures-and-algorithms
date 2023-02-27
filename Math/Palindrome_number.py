class Solution:
    def isPalindrome(self, x: int) -> bool:
        s=str(x)
        if(s==s[::-1]):
            return True
        return False
