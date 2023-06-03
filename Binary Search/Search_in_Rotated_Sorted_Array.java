

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
  This approach has a time complexity of O(log n).
  
*/
  
class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;    //finding the mid element
        while (start <= end) {    //until the target element is found or the start pointer becomes greater than the end pointer
            mid = (start + end) / 2;
            if (target == nums[mid]) {    //comparing it with the target element.
                return mid;   //If they are equal, it returns the mid index       
            }
            if (nums[start] <= nums[mid]) {   //If the left half of the array is sorted
                if (nums[start] <= target && nums[mid] >= target) {   // checking if the target lies between the start and the mid
                    end = mid - 1;    // updating the end pointer accordingly.
                } else {    //checking if the target lies between mid and end
                    start = mid + 1;    //updating the start pointer accordingly.
                }
            } else {     // If the right half of the array is sorted
                if (nums[end] >= target && nums[mid] <= target) {   //checking if the target lies between mid and end
                    start = mid + 1;    //updating the start pointer accordingly.
                } else {    //checking if the target lies between start and mid
                    end = mid - 1;    //updating the end pointer accordingly.
                }
            }
        }
        return -1;    //returns -1 if element not found
    }
}
