Example:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Here's an implementation in Go to merge two sorted arrays:

func merge(nums1 []int, m int, nums2 []int, n int) {
    i := m - 1 // Index of last element in nums1
    j := n - 1 // Index of last element in nums2
    
    // Merge from the end of the arrays to avoid overwriting
    for k := m + n - 1; k >= 0; k-- {
        if j < 0 {
            // No more elements in nums2, nums1 already sorted
            return
        }
        if i >= 0 && nums1[i] > nums2[j] {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
    }
}

The merge function takes in two sorted arrays nums1 and nums2, where nums1 has m elements and nums2 has n elements.
The function then merges nums2 into nums1 in-place, resulting in a single sorted array.

Starting from the end of both arrays, the function compares the last elements of nums1 and nums2, 
and puts the larger one at the end of nums1. This process continues until all elements in nums2 have been merged into nums1.

Note that since nums1 has enough space to accommodate all elements, we don't need to create a new array to store the merged elements.
We can just overwrite the 0 elements at the end of nums1 with the merged elements.
