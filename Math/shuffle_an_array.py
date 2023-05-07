#Problem statement - Given an integer array nums, design an algorithm to randomly shuffle the array. 
# All permutations of the array should be equally likely as a result of the shuffling.
# Complete the provided functions 

class Solution:

    def __init__(self, nums: List[int]):
        #the value of nums is stored as an instance variable that can be accessed and used by other methods within the class
        self.nums =  nums

              
    def reset(self) -> List[int]:
        #returning the original array after reseting it 
        return self.nums

    def shuffle(self) -> List[int]:
        s = [x for x in self.nums]
        random.shuffle(s)
        return s
# Time complexity - O(N), where N is the length of the input list self.nums 
#Space compelxity - O(N)


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
