class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        #Time Complexity - O(M+N)
        #Space Complexity - O(1)

        #Using similar to merge sort algorithm implementation.
        #Traversing in reverse order and comparing m,n values.
        #Placing the highest element last and continuing with the algorithm. 
        i, j, k = m - 1, n - 1, m + n - 1
        while(i >= 0 and j >= 0):
            if(nums1[i] > nums2[j]):
                nums1[k] = nums1[i]
                i -= 1
                k -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
                k -= 1
        
        #placing left over elements from num1 to nums1
        while(i >= 0):
            nums1[k] = nums1[i]
            i -= 1
            k -= 1
        
        #placing left over elements from num2 to num1
        while(j >= 0):
            nums1[k] = nums2[j]
            j -= 1
            k -= 1
