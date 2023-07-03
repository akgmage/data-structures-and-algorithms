/*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    Example 1:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Example 2:
    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Explanation: The longest increasing subsequence is [0,1,2,3], therefore the length is 4.

    Example 3:
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

    Explanation of the approach:
    1. We will use the concept of Dynamic Programming to solve this problem.
    2. We will create a dp array of size n, where n is the size of the given array.
    3. We will initialize the dp array with 1, as the length of the longest increasing subsequence ending at any index is atleast 1.
    4. We will iterate over the array from the second index to the last index.
    5. For each index, we will iterate over the array from the first index to the current index.
    6. If the current element is greater than the element at the inner loop, then we will update the dp array at the current index with the maximum of the current value and the value at the inner loop + 1.
    7. We will return the maximum value in the dp array.

    Time Complexity: O(N^2), where N is the size of the given array.
    Space Complexity: O(N), where N is the size of the given array.

*/

class Solution{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        // Initializing the dp array with 1, as the length of the longest increasing subsequence ending at any index is atleast 1.
        vector<int> dp(nums.size(), 1);
        // Iterating over the array from the second index to the last index.
        for (int i = 1; i < nums.size(); i++)
        {
            // Iterating over the array from the first index to the current index.
            for (int j = 0; j < i; j++)
            {
                // If the current element is greater than the element at the inner loop, then we will update the dp array at the current index with the maximum of the current value and the value at the inner loop + 1.
                // This is because, if the current element is greater than the element at the inner loop, then we can add the current element to the increasing subsequence ending at the inner loop element, and the length of the increasing subsequence ending at the current element will be the length of the increasing subsequence ending at the inner loop element + 1.
                // We will take the maximum of the current value and the value at the inner loop + 1, because we want to find the length of the longest increasing subsequence ending at the current element.
                // We will update the dp array at the current index with the maximum of the current value and the value at the inner loop + 1.
                if (nums[i] > nums[j])
                    dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        // Returning the maximum value in the dp array.
        return *max_element(dp.begin(), dp.end());
    }
};