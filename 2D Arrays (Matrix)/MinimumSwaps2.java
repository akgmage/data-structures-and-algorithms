/**
 * Problem Description
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).
 *
 * Find the minimum number of swaps required to sort the array in ascending order.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the minimum number of swaps.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 0]
 * Input 2:
 *
 * A = [2, 0, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
 *  You cannot sort it with lesser swaps.
 * Explanation 2:
 *
 *  You cannot sort it with lesser than 2 swaps.
 */
package Linear.Arrays.TwoDimensional;

public class MinimumSwaps2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 0};

        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve (int[] array) {
        // O(N) time | O(1) space
        int minSwaps = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i) {
                swap(i, array[i], array);
                minSwaps++;
                i--;
            }
        }
        return minSwaps;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
