/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/
#include<bits/stdc++.h>
class Solution {
public:
    int get_index(vector<int>& nums, int target, bool found){
        int ans = -1;
        int start = 0, end = nums.size() - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans = mid;
                if(found){
                    end = mid - 1; // search in left part
                }
                else{
                    start = mid + 1; // search in right part
                }
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans(2, -1);
        int first = get_index(nums, target, true);
        if(first == -1)
            return ans;
        int last = get_index(nums, target, false);
        //ans.push_back(first);
        //ans.push_back(last);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
};