/**
   Given an array of integers nums and an integer k,
  return the number of contiguous subarrays where the product of all the elements in the subarray is
  strictly less than k.

  The provided code defines a Java class Solution with a method numSubarrayProductLessThanK that counts the number
  of subarrays in an input array nums whose product is less than a given threshold k. It uses a sliding window
  approach to efficiently compute this count.

  Time Complexity:

  The code iterates through the nums array once, using two pointers (startWindow and endWindow) to define the
  sliding window. This results in a time complexity of O(N), where N is the length of the input array nums.
  Space Complexity:

  The code uses a constant amount of additional space to store integer variables (startWindow, product, and count).
  Therefore, the space complexity is O(1), which means it is independent of the size of the input array.
*/
 
 func numSubarrayProductLessThanK(nums []int, k int) int {
    startWindow := 0 // The left end of the sliding window
    product := 1    // Initialize product to 1 to accumulate the product
    count := 0      // Count of subarrays with a product less than k

    // Iterate through the array using a sliding window approach
    for endWindow := 0; endWindow < len(nums); endWindow++ {
        // Multiply the current element to the product
        product *= nums[endWindow]

        // Shrink the window by moving the start pointer as long as the product is greater than or equal to k
        for startWindow <= endWindow && product >= k {
            // Divide the product by the element at the start of the window
            product /= nums[startWindow]
            // Move the start of the window to the right
            startWindow++
        }

        // Update the count with the number of valid subarrays within the current window
        count += endWindow - startWindow + 1
    }

    // Return the count, which represents the number of subarrays with a product less than k
    return count
}
