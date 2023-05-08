/**
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
 *
 * Note: Using the library sort function is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 *
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 *
 * Output Format
 * Return an integer array in asked order
 *
 *
 * Example Input
 * Input 1 :
 *     A = [0 1 2 0 1 2]
 * Input 2:
 *
 *     A = [0]
 *
 *
 * Example Output
 * Output 1:
 *     [0 0 1 1 2 2]
 * Output 2:
 *
 *     [0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *     [0 0 1 1 2 2] is the required order.
 */

package Sorting;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 2, 2};

        int[] res = solve(array);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int[] array) {
        // O(n) time | O(1) space - where n is the length of the array

        int firstValue = 0;
        int secondValue = 1;

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
    public static void solve1(int[] array) {
        int firstValue = 0;
        int secondValue = 1;

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int currentNum = array[secondIdx];

            if (currentNum == firstValue) {
                swap(firstIdx, secondIdx, array);
            } else if (currentNum == secondValue) {
                secondIdx++;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx--;
            }
        }
    }






}
