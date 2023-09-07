class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Initialize the candidate as the first element
        int count = 1; // Initialize the count of the current candidate as 1
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                // If the current element is the same as the candidate, increment the count
                count++;
            } else if (count > 0) {
                // If the current element is different from the candidate and count is positive,
                // decrement the count since we have a matching pair (candidate vs. current element)
                count--;
            } else {
                // If count becomes zero, update the candidate to the current element and set count to 1
                candidate = nums[i];
                count = 1;
            }
        }
        
        // At the end, the candidate will be the majority element
        return candidate;
    }
}
