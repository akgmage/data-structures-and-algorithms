/*
Q -> Hash Table: You're given a list of integers nums.
Write a function that returns a boolean representing whether there exists a zero-sum subarray of nums in Java
*/

//Here's a Java code that implements a solution to find if there is a zero-sum subarray in the given list of
// integers using a hash table.

import java.util.*;

public class ZeroSumSubarray {

    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, -3, 2, 1, 8};
        boolean hasZeroSumSubarray = hasZeroSumSubarray(nums);
        System.out.println(hasZeroSumSubarray);
    }
}

/*
Explanation:-

The above code uses a HashSet to keep track of the prefix sum of the elements of the input array. At each index, it checks if the sum up to that index has already been seen before in the HashSet.
If it has been seen, it means that there exists a subarray with a zero sum. If the sum equals zero, then the subarray starts from the beginning of the array.
The time complexity of this algorithm is O(n), where n is the size of the input array, since we traverse the input array only once.
The space complexity is also O(n), since the HashSet can contain up to n elements in the worst case.
 */
