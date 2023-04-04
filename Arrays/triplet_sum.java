/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<List<Integer>> threeNumberSum(int[] nums, int targetSum) {
        Arrays.sort(nums); // Sort the input array in non-decreasing order
        List<List<Integer>> triplets = new ArrayList<>();
        
        // Loop through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // While the left index is less than the right index
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (currentSum == targetSum) {
                    // If the current triplet sums up to the target sum, add it to the result list
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move the left and right indices towards the center to find other triplets
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    // If the current triplet sums up to less than the target sum, move the left index towards the center to find larger numbers
                    left++;
                } else {
                    // If the current triplet sums up to more than the target sum, move the right index towards the center to find smaller numbers
                    right--;
                }
            }
        }
        
        return triplets;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = { 12, 3, 1, 2, -6, 5, -8, 6 };
        int targetSum = 0;
        
        List<List<Integer>> triplets = threeNumberSum(nums, targetSum);
        
        for (List<Integer> triplet : triplets) {
            System.out.print("[");
            for (int i = 0; i < triplet.size(); i++) {
                System.out.print(triplet.get(i));
                if (i < triplet.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
