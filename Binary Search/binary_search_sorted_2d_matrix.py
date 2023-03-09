class Solution:
    def __init__(self):
        self.index = -1
    def binarySearch(self,arr,low,high,key):
        if(low>high):
            return self.index
        mid=(low+high)//2
        if(arr[mid]>key):
            return Solution.binarySearch(self,arr,low,mid-1,key)
        elif(arr[mid]<key):
            self.index = mid
            return Solution.binarySearch(self,arr,mid+1,high,key)
        else:
            return mid
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix[0])
        m = len(matrix)

        arr = [matrix[i][0] for i in range(m)]
        ind1 = Solution.binarySearch(self,arr,0,m-1,target)
        self.index=-1
        ind2 = Solution.binarySearch(self,matrix[ind1],0,n-1,target)
        if(matrix[ind1][ind2] == target):
            return True
        return False
