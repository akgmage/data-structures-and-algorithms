/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
*/
#include <iostream>
#include <unordered_map>
#include <vector>

std::vector<int> twoNumberSum(std::vector<int>& nums, int target) {
    // Create an unordered_map to store the indices of the elements in the vector
    std::unordered_map<int, int> map;
    
    // Loop through the vector
    for (int i = 0; i < nums.size(); i++) {
        // Calculate the complement of the current element with respect to the target sum
        int complement = target - nums[i];
        
        // Check if the complement is already in the map
        if (map.count(complement) > 0) {
            // If the complement is in the map, return the indices of the two elements that sum up to the target
            return { map[complement], i };
        }
        
        // If the complement is not in the map, add the current element and its index to the map
        map[nums[i]] = i;
    }
    
    // If no two elements sum up to the target, return an empty vector
    return {};
}

int main() {
    // Example usage
    std::vector<int> nums = { 2, 7, 11, 15 };
    int target = 9;
    std::vector<int> result = twoNumberSum(nums, target);
    
    if (result.size() > 0) {
        std::cout << "Indices of the two numbers that sum up to " << target << ": ";
        for (int i : result) {
            std::cout << i << " ";
        }
        std::cout << std::endl;
    } else {
        std::cout << "No two numbers found that sum up to " << target << "." << std::endl;
    }
    
    return 0;
}
