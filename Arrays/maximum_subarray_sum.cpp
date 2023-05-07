// Maximum Subarray
/*
	The maxSubarraySum function takes an integer slice arr as input and returns the maximum subarray
	sum as an integer.

	The maxSoFar variable is initialized to the smallest possible integer value, since any valid subarray
	sum must be greater than or equal to this value. The maxEndingHere variable is initialized to 0,
	since an empty subarray has a sum of 0.

	The function then iterates through the elements of arr, updating maxEndingHere and maxSoFar as necessary.
	At each iteration, the maximum ending here is updated by adding the current element to it.
	If the maximum ending here becomes negative, it is reset to 0, since any subarray that includes a negative
	sum will not be the maximum subarray. If the maximum ending here is greater than the maximum subarray
	sum so far, maxSoFar is updated to the new maximum.

	Finally, the function returns maxSoFar.

	In the main function, an example input array is defined and passed to maxSubarraySum.
	The resulting maximum subarray sum is printed to the console.

	The time complexity of the above implementation of Kadane's algorithm for finding the maximum subarray sum is O(n),
	where n is the length of the input array. This is because we are iterating over each element of the array only once.

	The space complexity of the implementation is O(1), as we are only using a constant amount of extra space for
	storing the maximum subarray sum and the current subarray sum.

    Example Input: arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Example Output: 6
    Explanation: The maximum subarray sum is [4, -1, 2, 1] which adds up to 6.
    
*/
#include <iostream>
#include <vector>

using namespace std;

// Function to find the maximum subarray sum using Kadane's algorithm
int maxSubArraySum(vector<int>& nums) {
    int maxSum = INT_MIN;
    int currSum = 0;

    // Iterate over each element in the array
    for (int i = 0; i < nums.size(); i++) {
        // Add the current element to the current sum
        currSum += nums[i];

        // Update the maximum sum seen so far
        if (currSum > maxSum) {
            maxSum = currSum;
        }

        // If the current sum is negative, we reset it to zero
        if (currSum < 0) {
            currSum = 0;
        }
    }

    // Return the maximum sum
    return maxSum;
}

// Function to calculate maximum subarray sum using brute force approach
int maxSubarraySumBruteForce(vector<int>& nums) {
    int maxSum = INT_MIN; // Initialize maximum sum to smallest integer value
    // Consider all subarrays starting from i to j and calculate their sum
    for (int i = 0; i < nums.size(); i++) {
        int sum = 0; // Initialize sum for each subarray
        for (int j = i; j < nums.size(); j++) {
            sum += nums[j]; // Add element to sum
            // Update maxSum if sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
    }
    return maxSum; // Return maximum sum
}

// Driver code to test the function
int main() {
    // Example usage
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = maxSubArraySum(nums);
    cout << "Maximum subarray sum: " << maxSum << endl;
    maxSum = maxSubarraySumBruteForce(nums);
    cout << "Maximum subarray sum using brute force: " << maxSum << endl;

    return 0;
}
