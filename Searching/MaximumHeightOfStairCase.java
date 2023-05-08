/**
 * Problem Description
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
 *
 * The first stair would require only one block, and the second stair would require two blocks, and so on.
 *
 * Find and return the maximum height of the staircase.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 109
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the maximum height of the staircase using these blocks.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 10
 * Input 2:
 *
 *  A = 20
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The stairs formed will have height 1, 2, 3, 4.
 * Explanation 2:
 *
 *  The stairs formed will have height 1, 2, 3, 4, 5.
 */
package Searching;

public class MaximumHeightOfStairCase {
    public static void main(String[] args) {
        int a = 10;
        int ans = solve(a);
        System.out.println(ans);
    }
    public static int solve(int a) {
        // O(LogN) time | O(1) space
//        int sum = 0;
//        int i = 1;
//        while (true) {
//            sum += i;
//            i++;
//            if (sum == a) {
//                return i-1;
//            }
//            else if (sum > a) {
//                return i - 2;
//            }
//        }
        int low = 0, high = 1000 * 1000 * 1000, ans = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if ( (long) mid * (mid + 1)/2 > a) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
