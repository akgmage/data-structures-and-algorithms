'''
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    Constraints: string.length The string only consists of English letters

    Sample Input : "madame"
    Output : True

    Sample Input : "masdasd"
    Output : False	
    
'''
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
