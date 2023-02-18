/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
*/
import java.util.*;

public class TwoNumberSum {
    
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
    }
    
    // Brute Force Solution
    // Time complexity: O(N^2);
    // Space Complexity: O(1);
    public static int[] TwoSumBruteForce(int[] array, int targetSum) {
        for(int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for(int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum)
                    return new int[] {firstNum, secondNum};
            }
        } return new int[0];
    }

    // Sorting Solution
    // Time complexity: O(N log N);
    // Space Complexity: O(1);
    public static int[] TwoSumBySorting(int[] array, int targetSum) {
    // O(nlog(n)) time | O(1) space
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int firstNum = array[left];
            int secondNum = array[right];
            int currentSum = firstNum + secondNum;
            if(currentSum == targetSum) return new int[] {firstNum, secondNum};
            else if(currentSum < targetSum) left += 1;
            else right -= 1;
        } return new int[0];
    }
    
    // Optimal Solution
    // Time complexity: O(N);
    // Space Complexity: O(N);
    public static int[] TwoSumOptimal(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for(int num: array) {
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)) return new int[] {num, potentialMatch};
            nums.add(num);
        } return new int[0];
    }
}
