/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    

    Example 1:

    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:

    Input: nums = [1,2,3], k = 3
    Output: 2


    ### Explanation:

    The code is designed to count the number of subarrays within the 'nums' array whose elements sum to a given target integer 'k'. 
    It uses a hashmap to efficiently keep track of cumulative sums and their counts.

    Here's the code's key logic:

    1. It initializes a hashmap `sumIndex` to store cumulative sums as keys and their counts as values.

    2. It initializes variables `result` and `currentSum`.

    3. It adds a key-value pair of `(0, 1)` to the `sumIndex` hashmap to represent the sum of an empty subarray (0) and its count (1).

    4. It iterates through the elements of the 'nums' array.

    5. For each element, it adds the element's value to `currentSum`.

    6. It calculates the value to find in the hashmap by subtracting 'k' from the current cumulative sum, which is stored in the `toFind` variable.

    7. It checks if the hashmap contains the value 'toFind' and, if found, adds the count of subarrays that sum to 'toFind' to the 'result'.

    8. It updates the hashmap with the current cumulative sum. If the sum is already in the hashmap, it increments its count by 1. If it's not in the hashmap, 
    it adds it with a count of 1.

    9. Finally, it returns the 'result,' which represents the total number of subarrays with a sum of 'k'.

    ### Time Complexity:

    The time complexity of this code is O(n), where 'n' is the length of the 'nums' array. This is because the code iterates through the 'nums' 
    array once, and each iteration consists of constant-time operations (e.g., hashmap lookups and additions).

    ### Space Complexity:

    The space complexity of this code is O(n), where 'n' is the length of the 'nums' array. The space is primarily used for the hashmap `sumIndex`, 
    which can have up to 'n' distinct cumulative sums. In the worst case, all elements are unique, resulting in 'n' distinct cumulative sums, 
    each with a count of 1.

    In summary, this code efficiently counts subarrays with a sum of 'k' in O(n) time and uses O(n) space to store cumulative sums and their counts.
 */
#include <iostream>
#include <unordered_map>
#include <vector>

int subarraySum(std::vector<int>& nums, int k) {
  // Create an unordered_map to store cumulative sums as keys and their counts as values.
  std::unordered_map<int, int> sumIndex;
  // Initialize the result to 0.
  int result = 0;
  // Initialize a variable to track the current cumulative sum.
  int currentSum = 0;
  // Initialize the unordered_map with a key-value pair representing the sum of an empty subarray (0) and its count (1).
  sumIndex[0] = 1;

  // Iterate through the elements of the 'nums' vector.
  for (int i = 0; i < nums.size(); i++) {
    // Add the current element to the cumulative sum.
    currentSum += nums[i];
    // Calculate the value to find in the unordered_map by subtracting 'k' from the current cumulative sum.
    int toFind = currentSum - k;

    // Check if the unordered_map contains the value 'toFind'.
    if (sumIndex.find(toFind) != sumIndex.end()) {
      // If found, add the count of subarrays that sum to 'toFind' to the 'result'.
      result += sumIndex[toFind];
    }

    // Update the unordered_map with the current cumulative sum.
    // If it's already in the unordered_map, increment its count by 1.
    // If it's not in the unordered_map, add it with a count of 1.
    sumIndex[currentSum]++;

  }

  // Return the final result, which represents the total number of subarrays with a sum of 'k'.
  return result;
}

int main() {
  std::vector<int> nums = {1, 1, 1};
  int k = 2;
  int result = subarraySum(nums, k);
  std::cout << "Number of subarrays with sum " << k << " is: " << result << std::endl;
  return 0;
}
