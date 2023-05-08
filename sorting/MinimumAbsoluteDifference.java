/**
 * Problem Description
 * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
 *
 *
 *
 * Problem Constraints
 * 2 <= length of the array <= 100000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the minimum value of | A[i] - A[j] |.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The absolute difference between any two adjacent elements is 1, which is the minimum value.
 * Explanation 2:
 *
 *  The minimum value is 6 (|11 - 5| or |17 - 11|).
 */
package Sorting;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {4658, 7208, 2316, 2343, 3758, 1475, 8130, 2050,
                     2108, 4099, 9215, 264, 255, 1279, 5450, 6730,
                     8392, 6367, 4114, 6556, 9628, 8998, 6196, 5222,
                    1290, 4003, 2165, 9329, 6658, 1482, 4292, 1715,
                    8161, 3670, 5797, 9605, 3126, 2592, 6701, 3601,
                    4904, 4848, 2496, 3442, 5423, 6368, 4529, 3770,
                    57, 465, 360, 9361, 2056, 7112, 8223, 4709, 1724,
                   1, 2229, 7217, 5047, 649, 3961, 6792, 7528, 5590,
                   1715, 7133, 1616, 3516, 788, 5654, 288, 4118, 6960,
                  9647, 5142, 9349, 568, 6009, 4606, 829, 438, 689, 6812,
                 4210, 5340, 1825, 2071, 2446, 5613, 7533, 1922, 5128, 9116,
                 5209, 5269, 314, 3788, 4348, 7266, 8598, 3729, 8907, 3288,
                6575, 6956, 8488, 8570, 8303, 767, 9791, 3936, 8877, 4973,
                1145, 9396, 3820, 4194, 3218, 330, 1635, 7877, 8509, 5488,
                4558, 699, 640, 2095, 4341, 6674, 2058, 981, 5693, 7368,
                5362, 3831, 9938, 8409, 9118, 5432, 5358, 8731, 3811, 6064,
                8762, 3836, 7317, 3115, 4840, 7774, 2211, 6374, 6063, 8525,
                9078, 8526, 6049, 7959, 1048, 883, 3610, 705, 4772, 4538, 3015,
                5850, 2199, 8820, 8390, 1680, 5673, 2163, 6661, 6397, 6114, 5337,
                3905, 7130, 339, 3351, 4630, 5458, 8938, 282, 2079, 117, 563, 787,
                401, 6625, 1942, 3122, 6284, 9123, 5513, 1115, 8471 };

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        // O(NLogN) time | O(NLogN) space
        int mod = 1000 * 1000 * 1000 + 7;

        Arrays.sort(arr);

        long ans = Long.MAX_VALUE;
        int n = arr.length;

        for (int i = 1; i < n; i += 1) {
            long temp = (long) Math.abs(arr[i-1] - arr[i]);
            ans =  Math.min(temp, ans);
            ans %= mod;
        }
        return (int) ans;
    }
}
