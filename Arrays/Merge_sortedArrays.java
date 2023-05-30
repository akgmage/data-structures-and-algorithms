
// PROBLEM:- MERGE SORTED ARRAY 
// https://leetcode.com/problems/merge-sorted-array/description/

// Question:

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
// and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, 
// but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
// where the first m elements denote the elements that should be merged,
//  and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
/**SAMPLE I/O
  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
  Output: [1,2,2,3,5,6]

Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
 
 /**
  APPROACH:- 
  1. Use the 'm' and 'n' as the pointer of both the arrays.
  2. Loop through the array set the other pointer('shift') at last of nums1 to keep the track of empty array.
  3. Now compare nums1[m] to nums2[n], the bigger among them will be at nums1[shift](decrement the variables also).
  4. if m<0 or n<0 break.
  5. it is possible that there will be remaing element is nums2[] so copy them with the pointer 'shift'.
                 (The code is also well documented as well)
    

    Time Complexity: O(N) because we iterate nums1[] which also contain the space for nums2[]
    Space Complexity: O(1) Not extra array required, Hence constant space.

  */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) // If nums2 is empty, no merging required
            return;
        
        if (m == 0) { // If nums1 is empty, simply copy nums2 to nums1
            int shift = nums1.length - 1;
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int shift = m + n - 1; // Index to track the current position while merging
        m -= 1; // Decrement m to access the last element in nums1
        n -= 1; // Decrement n to access the last element in nums2
        
        while (n >= 0 && m >= 0) {          // Merge elements from the end of both arrays
            if (nums2[n] > nums1[m]) {      // If current element in nums2 is greater
                nums1[shift] = nums2[n];     // Place it in the current position in nums1
                shift -= 1;                  // Decrement the position index
                n -= 1;                         // Decrement n to move to the previous element in nums2
            } else if (nums2[n] <= nums1[m]) { // If current element in nums2 is less than or equal to the current element in nums1
                nums1[shift] = nums1[m];        // Place the current element in nums1 in the current position in nums1
                nums1[m] = 0;               // Set the current element in nums1 to 0 (to be ignored during merging)
                shift -= 1;             // Decrement the position index
                m -= 1;              // Decrement m to move to the previous element in nums1
            }
        }
        
        while (n >= 0) { // If there are remaining elements in nums2
            nums1[shift--] = nums2[n--]; // Copy them to the beginning of nums1
        }
    }
}
