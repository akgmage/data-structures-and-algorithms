//

Input: Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
Implement the Solution class:
Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

Example:
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

Time Complexity:O(n)
Space Complexity:O(n)

Explanation: In the shuffle function 
>>int[] rand = Arrays.copyOf(nums, nums.length); creates a copy of the original array nums using Arrays.copyOf() method.
This copy, called rand, will be shuffled to avoid modifying the original array.
  
>>The for loop iterates over each element of the array. The loop variable i represents the current index being processed.

>>Inside the loop, int r = (int) (Math.random() * (i+1)); generates a random index r between 0 and i, inclusive.
  This index r will be used to swap elements in the rand array.

>>The lines int temp = rand[i];, rand[i] = rand[r];, and rand[r] = temp; perform the swapping of elements.
  The element at index i is temporarily stored in temp, then the element at index r is moved to index i, and finally, the element stored in temp is moved to index r. This swapping step ensures a random shuffling of the elements.

>>After the loop completes, the shuffled array rand is returned.

>>The Fisher-Yates algorithm used in the shuffle() method ensures that each possible permutation of the array has an equal probability of occurring. 
  By swapping elements randomly, it guarantees a uniform and unbiased shuffling of the array.

  //

 import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] rand = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * (i+1));
            int temp = rand[i];
            rand[i] = rand[r];
            rand[r] = temp;
        }
        return rand;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        
        Solution solution = new Solution(nums);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter 1 to reset the array, 2 to shuffle the array, or 0 to exit:");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                int[] resetArray = solution.reset();
                System.out.println("Reset Array:");
                printArray(resetArray);
            } else if (choice == 2) {
                int[] shuffledArray = solution.shuffle();
                System.out.println("Shuffled Array:");
                printArray(shuffledArray);
            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
 
  

