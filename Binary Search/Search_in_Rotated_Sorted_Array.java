

/* Problem:
  There is an integer array nums sorted in ascending order (with distinct values).
  Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
  Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
  You must write an algorithm with O(log n) runtime complexity.
  
Sample Input-Output:

  Example 1:
  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
  
  Example 2:
  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1
  
  Example 3:
  Input: nums = [1], target = 0
  Output: -1
  
Constraints:
  1 <= nums.length <= 5000
  -104 <= nums[i] <= 104
  All values of nums are unique.
  nums is an ascending array that is possibly rotated.
  -104 <= target <= 104
  
Approach: 
  This approach has a time complexity of O(log n) using binary Search. 
*/
  
import java.util.*;
import java.lang.*;
import java.io.*;
public class Search_in_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(low<=high){
            int mid = (left+right)/2;
            // check if the current element is target
            if(nums[mid] == target)
                return mid;
            // if the starting index of the search space has smaller element than current element
            else if(nums[left]<=nums[mid]){
                // if target lies in non-rotated search space or subarray
                if(target >= nums[left] && target < nums[mid])
                    high = mid - 1;
                else
                    left = mid + 1;
            } else {
                // if target lies in non-rotated subarray
                if(target>nums[mid] && target<=nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        // if couldn't find the target element until now then it does not exists
        return -1;
    }
    
    public static void main(String[] args){
      int nums[] = {4,5,6,7,0,1,2};
      System.out.println(search(nums, 4));
    }
}
