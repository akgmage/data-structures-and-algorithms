/*
Majority Element


Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

-*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
        set.add(i);
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        int count = 0;
        for (Integer var : arr) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (var.intValue() == nums[j]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return var.intValue();
            }
        }
        return 0;
    }
}