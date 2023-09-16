#include <vector>

class Solution {
public:
    int totalHammingDistance(std::vector<int>& nums) {
        // Get the number of elements in the input vector
        int n = nums.size();
        // Initialize the variable to store the total Hamming distance
        int ans = 0;
        
        // Iterate through each bit position (from 0 to 31)
        for (int i = 0; i < 32; i++) {
            // Initialize a variable to count the number of set bits at the current bit position
            int count = 0;
            
            // Iterate through all elements in the vector
            for (int k = 0; k < n; k++) {
                // Count the number of set bits at the current bit position for each element
                count += (nums[k] >> i) & 1;
            }
            
            // Update the total Hamming distance by adding the product of set bits and unset bits
            ans += count * (n - count);
        }
        
        // Return the total Hamming distance
        return ans;
    }
};

/*
This program defines a Solution class with a totalHammingDistance method that calculates the total Hamming distance for the input vector nums. The outer loop iterates over each bit position (from 0 to 31), and the inner loop counts the number of set bits at that bit position for all elements in the vector. It then updates the ans variable by adding the product of the count of set bits and the count of unset bits at that position.

This code efficiently calculates the total Hamming distance for a vector of integers by considering each bit position separately. */
