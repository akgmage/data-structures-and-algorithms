class Solution:
    def binarySearch(nums,low,high,target):
        if(low>high):
            return -1
        mid = (low+high)//2
        if(nums[mid]<target):
            return Solution.binarySearch(nums,mid+1,high,target)
        elif(nums[mid]>target):
            return Solution.binarySearch(nums,low,mid-1,target)
        else:
            return mid
    
    def search(self, nums: List[int], target: int) -> int:
        #Finding the index where the array was rotated and binary searching the first and second parts for the target value.
        rotated_index = -1
        for i in range(len(nums)-1):
            if(nums[i]>nums[i+1]):
                rotated_index = i
                break
            
        return Solution.binarySearch(nums,0,rotated_index,target) & Solution.binarySearch(nums,rotated_index+1,len(nums)-1,target)
        