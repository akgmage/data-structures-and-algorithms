/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
*/

#include <iostream>
#include <vector>
#include <algorithm>
/*
    This implementation uses the two pointer technique to find all triplets in the input array that sum up to the target sum. 
    We first sort the input array in non-decreasing order to simplify the process of finding triplets. We then loop through 
    the array and use two pointers, one starting from the left and one starting from the right, to find triplets that sum up 
    to the target sum. For each iteration of the loop, we set the left pointer to the index immediately to the right of the 
    current index, and the right pointer to the index of the last element in the array. We then move the left and right pointers 
    towards the center, checking at each step whether the triplet formed by the current indices sums up to the target sum. 
    If it does, we add the triplet to the result vector and continue searching for other triplets. 
    If the sum is less than the target sum, we move the left pointer towards the center to find larger numbers. 
    If the sum is greater than the target sum, we move the right pointer towards the center to find smaller numbers.
*/
std::vector<std::vector<int>> threeNumberSum(std::vector<int>& nums, int targetSum) {
    // Sort the input array in non-decreasing order
    std::sort(nums.begin(), nums.end());
    
    std::vector<std::vector<int>> triplets;
    
    // Loop through the array
    for (int i = 0; i < nums.size() - 2; i++) {
        int left = i + 1;
        int right = nums.size() - 1;
        
        // While the left index is less than the right index
        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];
            
            if (currentSum == targetSum) {
                // If the current triplet sums up to the target sum, add it to the result vector
                triplets.push_back({ nums[i], nums[left], nums[right] });
                
                // Move the left and right indices towards the center to find other triplets
                left++;
                right--;
            } else if (currentSum < targetSum) {
                // If the current triplet sums up to less than the target sum, move the left index towards the center to find larger numbers
                left++;
            } else {
                // If the current triplet sums up to more than the target sum, move the right index towards the center to find smaller numbers
                right--;
            }
        }
    }
    
    return triplets;
}

int main() {
    // Example usage
    std::vector<int> nums = { 12, 3, 1, 2, -6, 5, -8, 6 };
    int targetSum = 0;
    
    std::vector<std::vector<int>> triplets = threeNumberSum(nums, targetSum);
    
    for (std::vector<int>& triplet : triplets) {
        std::cout << "[";
        for (int i = 0; i < triplet.size(); i++) {
            std::cout << triplet[i];
            if (i < triplet.size() - 1) {
                std::cout << ", ";
            }
        }
        std::cout << "]" << std::endl;
    }
    
    return 0;
}
