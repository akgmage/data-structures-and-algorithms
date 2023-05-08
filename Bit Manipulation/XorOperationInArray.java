/**
 * You are given an integer n and an integer start.
 *
 * Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
 *
 * Return the bitwise XOR of all elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, start = 0
 * Output: 8
 * Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
 * Where "^" corresponds to bitwise XOR operator.
 * Example 2:
 *
 * Input: n = 4, start = 3
 * Output: 8
 * Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 *
 * Apple
 * |
 * 2
 *
 * Bloomberg
 * |
 * 2
 *
 * Walmart Global Tech
 * |
 * 1
 */
package BitManipulation;

public class XorOperationInArray {

    public static void main(String[] args) {
        int start = 0, n = 5;
        int res = solve(n, start);
        System.out.println(res);
    }
    public static int solve(int n, int start) {

//        int res = 0, i = 0;
//
//        while (i < n) {
//            int currentNum = start + 2 * i;
//            res = res ^ currentNum;
//            i++;
//        }

        int startValue = start;
        startValue = findXor(startValue);
        int endValue = findXor(n);
        return startValue ^ endValue;
    }

    public static int findXor(int n) {
        int ans = Integer.MIN_VALUE;

        if (n % 4 == 0) ans = n;
        else if (n % 4 == 1) ans = 1;
        else if (n % 4 == 2) ans = n + 1;
        else if (n % 4 == 3) ans = 0;

        return ans;
    }
}
