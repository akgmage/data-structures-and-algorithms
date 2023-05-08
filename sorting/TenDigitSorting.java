/**
 *  Tens Digit Sorting
 *
 *
 * Problem Description
 * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
 *
 * If a number has no tens digit, we can assume value to be 0.
 * If 2 numbers have same tens digit, in that case number with max value will come first
 * Solution should be based on comparator.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 *
 *
 * Output Format
 * Return the array after sorting
 *
 *
 *
 * Example Input
 * Input 1:
 * A = [15, 11, 7, 19]
 * Input 2:
 * A = [2, 24, 22, 19]
 *
 *
 * Example Output
 * Output 1:
 * [7, 19, 15, 11]
 * Output 2:
 * [2, 19, 24, 22]
 *
 *
 * Example Explanation
 * For Input 1:
 * The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
 * and that of 19, 15 and 11 is 1.
 * For Input 2:
 * The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
 * that of 19 is 1 and that of 22 and 24 is 2.
 */

package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TenDigitSorting {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(908, 903, 809, 801, 700, 608));

        int[] arr = {7, 19, 15, 11};

        // Using ArrayList
        ArrayList<Integer> res = solve(array);
        System.out.println(res);

        // Using Array
//        int[] res = solve(arr);
//        System.out.println(Arrays.toString(res));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array) {
        // O(N(Log(N)) time | O(1) space
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer val1, Integer val2) {
                int num1 = (val1 / 10) % 10;
                int num2 = (val2 / 10) % 10;

                if (num1 == num2) return val2.compareTo(val1);
                return num1 - num2;
            }
        };

        array.sort(comparator);

        return array;
    }

    public static int[] solve(int[] array) {
        // O(N(Log(N)) time | O(1) space

        Integer[] arr = new Integer[array.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = array[i];
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer val1, Integer val2) {
                Integer num1 = val1 / 10;
                Integer num2 = val2 / 10;

                return num1.compareTo(num2);
            }
        };

        Arrays.sort(arr, comparator);

        for (int i = 0; i < arr.length; i++)
            array[i] = arr[i];
        return array;
    }
}
