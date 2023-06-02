import java.util.*;

class Three_number_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();  // Set to store unique triplets
        List<List<Integer>> pairs = new ArrayList<>();  // List to store the resulting triplets
        Arrays.sort(nums);  // Sort the input array in ascending order
        
        for (int i = 0; i < nums.length; i++) {  // Iterate through the array
            for (int j = i + 1; j < nums.length; j++) {  // Iterate through the remaining elements after i
                int num1 = nums[i], num2 = nums[j];  // Current pair of numbers
                
                // Perform binary search to find the third number that complements the sum to 0
                int index = binarySearch(j + 1, nums.length - 1, -(num1 + num2), nums);
                
                // Check if the third number exists and forms a triplet with num1 and num2 that sums up to 0
                if (index >= 0 && index < nums.length && (nums[index] + num1 + num2 == 0)) {
                    List<Integer> triplet = List.of(num1, num2, nums[index]);  // Create the triplet
                    if (!triplets.contains(triplet)) {  // Check if the triplet is unique
                        pairs.add(triplet);  // Add the triplet to the resulting list
                        triplets.add(triplet);  // Add the triplet to the set to avoid duplicates
                    }
                }
            }
        }
        
        return pairs;  // Return the resulting list of triplets
    }

    private int binarySearch(int start, int end, int target, int[] arr) {
        if (start > end) return start;  // Base case: target not found, return the insertion position
        int index = (end - start) / 2 + start;  // Calculate the middle index
        if (arr[index] == target) return index;  // Base case: target found, return the index
        else if (arr[index] < target) return binarySearch(index + 1, end, target, arr);  // Search the right half
        else return binarySearch(start, index - 1, target, arr);  // Search the left half
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -3, 5, 2, 6};

        Three_number_sum solution = new Three_number_sum();  // Create an instance of the class
        List<List<Integer>> ans = solution.threeSum(nums);  // Call the threeSum method

        System.out.println(ans);  // Print the resulting triplets
    }
}

// Explanation
// The given code finds unique triplets in an array that sum up to zero using sorting and binary search. Here's a shorter explanation:

// 1. Sort the input array in ascending order.
// 2. Iterate through pairs of numbers in the array.
// 3. Perform binary search to find the third number that complements the sum to zero.
// 4. Add unique triplets to the result list.
// 5. Return the resulting list of triplets.

// Time Complexity: O(n^2 * log(n))

// Space Complexity: O(n)
