import java.util.*;

class two_sum {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=1, gap = 1;  // Initialize variables i, j, and gap
        
        while(i<nums.length){  // Start a loop that continues until i reaches the end of the array
            if(nums[i]+nums[j]== target){  // Check if the sum of nums[i] and nums[j] is equal to the target
                return new int[]{i,j};  // If the sum is equal to the target, return the indices [i, j] as the result
            }
            if(j>=nums.length-1){  // Check if j has reached the end of the array
                gap++;  // Increment the gap variable
                j = gap;  // Reset j to the value of gap
                i=0;  // Reset i to 0 to start checking the next set of pairs
            }
            else{
                i++;  // Move i one position up
                j++;  // Move j one position up
            }
        }
        return new int[]{-1,-1};  // If no pair is found, return [-1, -1] to indicate that a solution doesn't exist
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -3, 5, 4, 6};
        int target = 6;

        int[] pair = twoSum(nums, target);  // Call the twoSum method to find the pair of numbers

        System.out.println("The Two Numbers positions are " + pair[0] + " " + pair[1] + " That sum up to "+ target);  // Print the result
    }
}


//---------------Explanation---------------------

//       Problem Statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//      Approach:
//      1. We have Two pointers, `i` and `j` that start from `0` and `1`
//      2. We loop until i reaches the end, We keep moving j up in each interation.
//      3. Increase a variable `gap` for each time j reaches the end. We also move i one position up each time j reaches the end.
//      4. If we find a pair, We return it.
//      5. If `i` reaches the end, that means a solution doesnt exist. So we return [-1,-1].

// Time Complexity: O(n^2)
// Space Complexity: O(1)