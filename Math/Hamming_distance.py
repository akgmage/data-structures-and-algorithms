class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        '''By using bit manipulation, as all the array elements are 32-bit array elements, we calculate all the number of set bits and unset bits as we need to consider the permutations, we take setbits*unsetbits.'''
        hamming_dist,n = 0,len(nums)
        for i in range(32):
            count = 0
            for element in nums:
                #Right shifting the element by the index and performing &1 lets us know if a bit is set or not
                if((element>>i)&1):
                    count+=1
            #Adding all the combinations where there are set and unset bits.
            hamming_dist+=count*(n-count)
        return hamming_dist