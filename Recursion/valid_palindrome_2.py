class Solution:
    def subPalindrome(self,s,low,high,count):
        if(low>high):
            return True
        if(count>1):
            return False
        if(s[low]!=s[high]):
            return Solution.subPalindrome(self,s,low+1,high,count+1) or Solution.subPalindrome(self,s,low,high-1,count+1)
        else:
            return Solution.subPalindrome(self,s,low+1,high-1,count)

    def validPalindrome(self, s: str) -> bool:
        if(s==s[::-1]):
            return True
        return Solution.subPalindrome(self,s,0,len(s)-1,0)

print(Solution().validPalindrome("ebcbbececabbacecbbcbe"))
print(Solution().validPalindrome("cdbeeeabddddbaeedebdc"))
