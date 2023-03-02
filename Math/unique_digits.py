class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        '''For n = 0, ans = 1
        For n = 1, ans = 10
        If we take 2 digit number, we have 9 options for first digit (1 - 9)
     and 9 options for second digit(0 & all other digits except the one taken as first digit (to keep      digits unique)) therefore ans += (9 * 9)
    Similarly if we take 3 digit number we have 8 options for third digit, therefore ans += (9 * 9 * 8)'''
        if(n==0): return 1 
        if(n==1): return 10
        unique = 10
        digits = 9
        for i in range(2,n+1):
            digits*=(10-i+1)
            unique+=digits
        return unique
    