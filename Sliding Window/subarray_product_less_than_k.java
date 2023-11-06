/**
 Given an array of integers nums and an integer k, 
 return the number of contiguous subarrays where the product of all the elements in the subarray is 
 strictly less than k.
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int startWindow = 0, product = 1, count = 0;

        for(int endWindow = 0; endWindow < nums.length; endWindow++) {
            product *= nums[endWindow];
            while(startWindow <= endWindow && product >= k) {
                product /= nums[startWindow];
                startWindow++;
            }
            count += endWindow - startWindow + 1;
        }
        return count;
    }
}