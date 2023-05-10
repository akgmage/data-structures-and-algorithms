'''Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Number of Substrings With Only 1s in Python
Issue Number : #518
Problem statement : 

Explanation of the below Python code :

The implementation is quite similar to the C++ implementation. We iterate over the string s using a for loop and keep track of the count of consecutive 1's using the variable count. Whenever we encounter a '0', we calculate the number of substrings that can be formed using the formula n*(n+1)/2, add it to the final answer ans, and reset the value of count to 0. Finally, we calculate the number of substrings for the last substring of consecutive 1's, add it to the final answer ans, and return the result modulo 10^9 + 7. Note that we have used the integer division operator // to perform the division in Python.



'''

----------------------------------------------------------------------------------------------//Python code begins here--------------------------------------------------------------------------------------------------------------------------------------
class Solution:
    def numSub(self, s: str) -> int:
        count = 0  # count the number of consecutive ones
        ans = 0    # variable to store the final answer
        for i in range(len(s)):
            if s[i] == '1':
                count += 1
            else:
                # calculate the number of possible substrings that can be formed
                # from the current consecutive ones and add it to the final answer
                ans = (ans + (count*(count+1))//2) % (10**9 + 7)
                count = 0
        # handle the case when the string ends with consecutive ones
        ans = (ans + (count*(count+1))//2) % (10**9 + 7)
        return ans
