/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

//approach----
//here we make a map which maintain the frequency of each array element while traversing through the element.
//and also check the frequency at the same time..if frequency(occurence) of any  element is  greater than (n/2) at anytime we will return that element.
// suppose if no such element exist return simply -1.

Find Majority Element in C++ 
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
       unordered_map<int,int>mp;
        for(int i:nums){
            if(++mp[i]>nums.size()/2){
                return i;
            }
        }
        return -1;
    }
};
