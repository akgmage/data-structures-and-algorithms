import java.util.*;

/**
 *

 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty array.

 Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single integer to itself in order to obtain the target sum.

 You can assume that there will be at most one pair of numbers summing up to the target sum.
 Sample Input

 array = [3, 5, -4, 8, 11, 1, -1, 6]
 targetSum = 10

 Sample Output

 [-1, 11] // the numbers could be in reverse order


 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
    }
    public static int[] twoNumberSumOptimal(int[] array, int targetSum) {
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
    public static int[] twoNumberSumUsingSet(int[] array, int targetSum) {
// O(n) time | O(n) space
        Set<Integer> nums = new HashSet<>();
        for(int num: array) {
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)) return new int[] {num, potentialMatch};
            nums.add(num);
        } return new int[0];
    }
    public static int[] twoNumberSumBruteForce(int[] array, int targetSum) {
// O(n^2) time | O(1) space
        for(int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for(int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum)
                    return new int[] {firstNum, secondNum};
            }
        } return new int[0];
    }
}
