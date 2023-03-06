class Solution:
    #Approach-1
    #Time Complexity - O(N^2), Space complexity - O(N)
    #Adding brute-force values into hash_map and calculating the max_length
    def lengthOfLongestSubstring(self, s: str) -> int:
        if(len(s)==0 or len(s)==1):
            return len(s)
        max_length = 0
        for i in range(len(s)):
            temp_length,temp = 0,set()
            for j in range(i,len(s)):
                if(temp_length<j-i+1 and s[j] not in temp):
                    temp_length = j-i+1
                    max_length = max(max_length,temp_length)
                    temp.add(s[j])
                else: 
                    break
        return max_length
    
    #Approach - 2
    #Time Complexity - O(N), WorstCase-O(N^2), Space Complexity - O(N)
    def lengthOfLongestSubstring(self, s: str) -> int:
        if(len(s)==0):
            return 0
        hash_set = set()
        start_ind,end_ind = 0,0
        max_length = -1
        while(end_ind<len(s)):
            if(s[end_ind] not in hash_set):
                hash_set.add(s[end_ind])
                end_ind+=1
                max_length = max(max_length,len(hash_set))
            else:
                hash_set.remove(s[start_ind])
                start_ind+=1
        return max_length
