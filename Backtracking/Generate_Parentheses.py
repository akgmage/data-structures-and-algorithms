'''
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    
    Example 2:
    Input: n = 1
    Output: ["()"]
    Constraints:
    1 <= n <= 8
'''
class Solution:
    #reference: GeeksforGeeks for comments
    '''To form all the sequences of balanced bracket subsequences with n pairs. So there are n opening brackets and n closing brackets. So the subsequence will be of length 2*n. There is a simple idea, the i’th character can be ‘{‘ if and only if the count of ‘{‘ till i’th is less than n and i’th character can be ‘}’ if and only if the count of ‘{‘ is greater than the count of ‘}’ till index i. If these two cases are followed then the resulting subsequence will always be balanced'''

    def generate(self,n,open,close,s,final_arr):
        if(open==n and close==n):
            final_arr.append(s)
            return
        if(open<n):
            Solution.generate(self,n,open+1,close,s+"(",final_arr)
        if(close<open):
            Solution.generate(self,n,open,close+1,s+")",final_arr)

    def generateParenthesis(self, n: int) -> List[str]:
        final_arr = []
        Solution.generate(self,n,0,0,"",final_arr)
        return final_arr