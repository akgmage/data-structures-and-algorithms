/**
 * Three Number Sort
 *
 * You're given an array of integers and another array of three distinct integers. The first array is guaranteed to only contain integers that are in the second array, and the second array represents a desired order for the integers in the first array. For example, a second array of [x, y, z] represents a desired order of [x, x, ..., x, y, y, ..., y, z, z, ..., z] in the first array.
 *
 * Write a function that sorts the first array according to the desired order in the second array.
 *
 * The function should perform this in place (i.e., it should mutate the input array), and it shouldn't use any auxiliary space (i.e., it should run with constant space: O(1) space).
 *
 * Note that the desired order won't necessarily be ascending or descending and that the first array won't necessarily contain all three integers found in the second array—it might only contain one or two.
 * Sample Input
 *
 * array = [1, 0, 0, -1, -1, 0, 1, 1]
 * order = [0, 1, -1]
 *
 * Sample Output
 *
 * [0, 0, 0, 1, 1, 1, -1, -1]
 */

package Sorting;

import java.util.Arrays;

public class ThreeNumberSort {
    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        int[] res = solve(array, order);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int[] array, int[] order) {
        // O(n) time | O(1) space - where n is the length of the array

        int firstValue = order[0];
        int secondValue = order[1];

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx];

            if (value == firstValue) {
                swap(firstIdx, secondIdx, array);
                firstIdx += 1;
                secondIdx += 1;
            } else if (value == secondValue)
                    secondIdx++;
            else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx -= 1;
            }
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
