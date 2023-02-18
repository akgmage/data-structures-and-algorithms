/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
*/
// Two Pointer approach
// sort the given array, set i as initial index and j as last
// add element at i and j and compate with target, if it matches then return
// if element is greater then target decrease index of j by 1
// if element is lesser then target increase index of i by 1
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        vector<int> result; // result vector
        for(int i = 0; i < nums.size(); i++){
            // lets say first element in our array is 3, and target sum is 10
            // then we will look for 7 in our map, if its present then we simply return 7 and 3 
            int to_find = target - nums[i];
            // if the required value is found then store result
            if(mp.find(to_find) != mp.end()){
                result.push_back(mp[to_find]);
                result.push_back(i);
                return result;
            }
            // keep track of what value in array we have seen so far
            mp[nums[i]] = i;
        }
        return result;
    }
};