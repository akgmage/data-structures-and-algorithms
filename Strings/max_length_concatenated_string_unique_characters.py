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