/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 *
 *
 *
 * Input Format
 * The first argument is an array of integers.
 *
 *
 *
 * Output Format
 * Return a string representing the largest number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 30, 34, 5, 9]
 * Input 2:
 *
 *  A = [2, 3, 9, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  "9534330"
 * Output 2:
 *
 *  "9320"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 *
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 *
 *
 * Reference : https://leetcode.com/problems/largest-number/solutions/53158/my-java-solution-to-share/
 */
package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};
        String res = solve(array);
        System.out.println(res);
    }

    public static String solve(int[] array) {
        // O(N(Log(N)) time | O(n) space
        if (array == null || array.length == 0) return "";

        int len = array.length;
        //1. Convert int array to String array
        String[] stringArray = new String[len];
        for (int i = 0; i < len; i++)
            stringArray[i] = String.valueOf(array[i]);

        //2. custom comparator to decide which string should come first.
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { // Eg: s1 = "9", s2 = "31"
                String s1 = o1 + o2; // "931"
                String s2 = o2 + o1; // "319"

                return s2.compareTo(s1); // reverse order
            }
        };

        //3. Sort Strings according to custom comparator
        Arrays.sort(stringArray, comparator);

        // An extreme edge case by leetcode, say you have only a bunch of 0 in your int array
        //  If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (stringArray[0].charAt(0) == '0') return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
