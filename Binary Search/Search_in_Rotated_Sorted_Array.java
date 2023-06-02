

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
  Search for the peak element i.e. pivot then search from 0 to pivot. If found return index else search from pivot+1 to nums.length
  
*/
  
class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int pivot=findpivot(nums);
        if(pivot==-1){
            return searcharray(0,nums.length-1,nums,target);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return searcharray(0,pivot,nums,target);
        }
        return searcharray(pivot+1,nums.length-1,nums,target);
    }
    
    int searcharray(int start,int end,int[] arr,int target){
        int middle;
        while (start <= end) {
            middle = start + ((end - start) / 2);
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                end = middle - 1;
            } else if (arr[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
    
    int findpivot(int[] nums){
        int start=0,end=nums.length-1,mid;
        while(start<=end){
            mid=start+((end-start)/2);
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end=mid-1;
            }
            else{
                start=mid;
            }
        }
        return -1;
    }
}
