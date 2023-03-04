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