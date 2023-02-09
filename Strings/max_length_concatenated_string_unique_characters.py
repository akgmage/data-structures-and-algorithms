# Question ->

# You are given an array of strings arr. A string s is formed by the concatenation 
# of a subsequence of arr that has unique characters.

# Return the maximum possible length of s.

# A subsequence is an array that can be derived from another array 
# by deleting some or no elements without changing the order of the remaining elements.


# Sample IO ->

# Example 1:

# Input: arr = ["un","iq","ue"]
# Output: 4
# Explanation: All the valid concatenations are:
# - ""
# - "un"
# - "iq"
# - "ue"
# - "uniq" ("un" + "iq")
# - "ique" ("iq" + "ue")
# Maximum length is 4.
# Example 2:

# Input: arr = ["cha","r","act","ers"]
# Output: 6
# Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
# Example 3:

# Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
# Output: 26
# Explanation: The only string in arr has all 26 characters.
 

# Solution ->

class Solution:
    def maxLength(self, arr: List[str]) -> int:
        
        # [1] we should first throw away all strings with any
        #    duplicate characters; strings with all unique 
        #    characters are the subsets of the alphabet, 
        #    thus, can be stored using 'set'
        unique = []
        for s in arr:
            u = set(s)
            if len(u) == len(s): unique.append(u)
        
        # [2] now start with an empty concatenation and iteratively
        #    increase its length by trying to add more strings
        concat = [set()]
        for u in unique:
            for c in concat:
                if not c & u:
                    concat.append(c | u)
        
        return max(len(cc) for cc in concat)