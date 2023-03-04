'''
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, return the Hamming distance between them.

    Example 1:
    Input: x = 1, y = 4
    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
        ↑   ↑
    The above arrows point to positions where the corresponding bits are different.
    
    Example 2:
    Input: x = 3, y = 1
    Output: 1

    Constraints:
    0 <= x, y <= 231 - 1
'''
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