// Description:
//  You are given two integer arrays nums1 and nums2,
// sorted in non-decreasing order, and two integers 
// m and n, representing the number of elements in 
// nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted 
// in non-decreasing order.

// The final sorted array should not be returned by
// the function, but instead be stored inside the 
// array nums1. To accommodate this, nums1 has a 
// length of m + n, where the first m elements denote
// the elements that should be merged, and the last
// n elements are set to 0 and should be ignored. 
// nums2 has a length of n.

// Sample Input/Output:
 
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3

// Output: [1,2,2,3,5,6]

// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].

// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1

// Time complexity of this code is O(m+n)
// Space complexity is O(1)

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int tar = m + n - 1;  // size of nums1 

        int i = m - 1;        // index of last element of nums1

        int j = n - 1;     // index of last element of nums2

        while(j >= 0) {    // iterate from last

            if( i >= 0 && nums1[i] > nums2[j]) 
                nums1[tar--] = nums1[i--]; 
            else 
                nums1[tar--] = nums2[j--];
                           
        }
    }
};
