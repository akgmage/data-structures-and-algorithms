/*
    You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

    Return the maximum score you can get by erasing exactly one subarray.

    An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

    

    Example 1:

    Input: nums = [4,2,4,5,6]
    Output: 17
    Explanation: The optimal subarray here is [2,4,5,6].
    Example 2:

    Input: nums = [5,2,1,2,5,2,1,2,5]
    Output: 8
    Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

    Explanation:

    startWindow: The left end of the sliding window.
    windowSum: Sum of elements within the current window.
    res: Result, initialized to 0, representing the maximum unique subarray sum.
    mp: HashMap to store the last index where each element was seen.
    Sliding Window:

    Use a for loop to iterate through the array with the endWindow as the right end of the window.
    Check if the current element is already in the window using a while loop.
    If yes, remove the element at the start of the window from the HashMap and update windowSum and startWindow.
    Update HashMap and windowSum:

    Add the current element to the HashMap and update windowSum.
    Update Result:

    Update the result (res) with the maximum unique subarray sum.
    Return Result:

    Return the final result, which represents the maximum unique subarray sum.
    This code efficiently finds the maximum sum of a subarray where all elements are unique using a sliding window and a HashMap to keep track of the last index of each element encountered.

*/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // Initialize pointers, windowSum, and result
        int startWindow = 0; // The left end of the sliding window
        int windowSum = 0;   // Sum of elements within the current window
        int res = 0;         // Result, which represents the maximum unique subarray sum

        // HashMap to store the last index where each element was seen
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Iterate through the array using a sliding window approach
        for (int endWindow = 0; endWindow < nums.length; endWindow++) {
            // Check if the current element is already in the window
            while (mp.containsKey(nums[endWindow])) {
                // Remove the element at the start of the window from the HashMap and update windowSum
                mp.remove(nums[startWindow]);
                windowSum -= nums[startWindow];
                startWindow++;
            }

            // Add the current element to the HashMap and update windowSum
            mp.put(nums[endWindow], 1);
            windowSum += nums[endWindow];

            // Update the result with the maximum unique subarray sum
            res = Math.max(res, windowSum);
        }

        // Return the result, which represents the maximum unique subarray sum
        return res;
    }
}
