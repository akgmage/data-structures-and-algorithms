/**
 Given an array of integers nums and an integer k, 
 return the number of contiguous subarrays where the product of all the elements in the subarray is 
 strictly less than k.
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Initialize pointers and a count variable
        int startWindow = 0; // The left end of the sliding window
        int product = 1;    // Initialize product to 1 to accumulate the product
        int count = 0;      // Count of subarrays with a product less than k

        // Iterate through the array using a sliding window approach
        for (int endWindow = 0; endWindow < nums.length; endWindow++) {
            // Multiply the current element to the product
            product *= nums[endWindow];

            // Shrink the window by moving the start pointer as long as the product is greater than or equal to k
            while (startWindow <= endWindow && product >= k) {
                // Divide the product by the element at the start of the window
                product /= nums[startWindow];
                // Move the start of the window to the right
                startWindow++;
            }

            // Update the count with the number of valid subarrays within the current window
            count += endWindow - startWindow + 1;
        }

        // Return the count, which represents the number of subarrays with a product less than k
        return count;
    }
}
