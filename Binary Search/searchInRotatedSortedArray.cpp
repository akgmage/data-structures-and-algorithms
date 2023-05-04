/*
	Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
	You must write an algorithm with O(log n) runtime complexity.

	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
	
	Input: nums = [1], target = 0
	Output: -1

	Constraints:
	>  1 <= nums.length <= 5000
	>  -104 <= nums[i] <= 104
	>  All values of nums are unique.
	>  nums is an ascending array that is possibly rotated.
	>  -104 <= target <= 104

	APPROACH
	1. Find the index at which the array has been rotated with the help of Binary Search.
	2. Store the index of rotation as INDX and find the range where target might be found using the following comparision:
			RANGE = {INDX+1, HIGH} if TARGET < NUMS[LOW]
			RANGE = {LOW, INDX-1}  if TARGET > NUMS{HIGH]
	3. Perform Binary Search for TARGET in the required range.
	4. If target is not found return -1.

	TIME COMPLEXITY : O(NlogN)  SPACE COMPLEXITY: O(1)
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
        // Initialize Variable for later Usage
        int n=nums.size();
        int low=0;
        int high=n-1;

        //Find the Rotation Point in the Rotated Array
        while(low<=high){
            int mid=(low+high)/2;
            if(mid==0 || mid==n-1){
                low=mid;
                break;
            }
            if(nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid]){
                low=mid;
                break;
            }
            else if(nums[mid]>nums[low] && nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        // Re-initialize Variables Needed
        int indx=low;
        low=0, high=n-1;
        if(target==nums[indx]){
            return indx;
        }
        else if(target>nums[high]){
            high=indx-1;
        }
        else if(target<nums[low]){
            low=indx+1;
        }

        // Binary  Search for Target in range low-high
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        // If target not found return -1
        return -1;
    }
};