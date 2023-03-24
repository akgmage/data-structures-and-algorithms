class Solution:
    def __init__(self):
        self.start_index=-1
        self.end_index=-1
    
    ''' Time complexity - O(logn), Space complexity - O(1)''''
    '''Once the binary Search is implemented, to find the start_index, we store the current index where we find the target and implement search again on the left side of the array'''
    def binarySearchFirst(self,arr,low,high,target):
        if(low>high):
            return 
        mid=(low+high)//2
        if(arr[mid]>target):
            Solution.binarySearchFirst(self,arr,low,mid-1,target)
        elif(arr[mid]<target):
            Solution.binarySearchFirst(self,arr,mid+1,high,target)
        else:
            self.start_index = mid
            Solution.binarySearchFirst(self,arr,low,mid-1,target)
    
    '''Once the binary Search is implemented, to find the end_index, we store the current index where we find the target and implement search again on the right side of the array'''
    def binarySearchLast(self,arr,low,high,target):
        if(low>high):
            return 
        mid=(low+high)//2
        if(arr[mid]>target):
            Solution.binarySearchLast(self,arr,low,mid-1,target)
        elif(arr[mid]<target):
            Solution.binarySearchLast(self,arr,mid+1,high,target)
        else:
            self.end_index = mid
            Solution.binarySearchLast(self,arr,mid+1,high,target)
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        #implementing binarySearchLast to populate the self.end_index
        Solution.binarySearchLast(self,nums,0,len(nums)-1,target)

        #implementing binarySearchFirst to populate the self.start_index
        Solution.binarySearchFirst(self,nums,0,len(nums)-1,target)
        return [self.start_index, self.end_index]