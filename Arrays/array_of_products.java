/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the product array.
 * Constraints
 *
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 * Input 2:
 *     A = [5, 1, 10, 1]
 * Output 2:
 *     [10, 50, 5, 50]
 */
package PrefixSum;

import java.util.Arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // O(n) time | O(n) space
        int length = array.length;
        int products[] = new int[length];

        int leftRunningProduct = 1;
        for (int i = 0; i < length; i++) {
            int currentNum = array[i];
            products[i] = leftRunningProduct;
            leftRunningProduct *= currentNum;
        }

        int rightRunningProduct = 1;
        for (int i = length - 1; i > -1; i--) {
            int currentNum = array[i];
            products[i] *= rightRunningProduct;
            rightRunningProduct *= currentNum;
        }
        return products;
    }
}
