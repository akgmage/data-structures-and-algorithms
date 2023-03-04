'''
  Write a function that takes in a non-empty array of integers that are sorted
  in ascending order and returns a new array of the same length with the squares
  of the original integers also sorted in ascending order.

  Sample Input: [-6, 1, 2, 3, 4]
  Output: [1, 4, 6, 16, 36]
'''
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        #Considering two pointer approach
        i,j=0,len(nums)-1
        final_array=[]
        while(i<=j):
            #comparing absolute values of the starting and the ending elements
            #if the second-pointer element is greateer, we add it to the list. If not, we add the first-pointer element
            if(abs(nums[i])<abs(nums[j])):
                final_array.append(pow(nums[j],2))
                j-=1    
            else:
                final_array.append(pow(nums[i],2))
                i+=1
        #returning reverse order as the array would be sorted in reverse.
        return final_array[::-1]