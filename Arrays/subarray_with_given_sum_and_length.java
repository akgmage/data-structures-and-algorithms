/**
 * Given an array A of length N. Also given are integers B and C.
 *
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 104
 *
 * 1 <= B <= N
 *
 * 1 <= C <= 109
 *
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 * The remaining arguments B and C are integers
 *
 *
 *
 * Output Format
 * Return 1 if such a subarray exist and 0 otherwise
 *
 *
 * Example Input
 * Input 1:
 * A = [4, 3, 2, 6]
 * B = 2
 * C = 5
 * Input 2:
 *
 * A = [4, 2, 2]
 * B = 2
 * C = 8
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 * The subarray [3, 2] is of length 2 and sum 5.
 * Explanation 2:
 * There are no such subarray.
 */

package SlidingWindow;

public class SubarrayWithGivenSumAndLength {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        int[] array = {4, 3, 2, 6};
        int b = 2;
        int c = 5;
        int ans = solve(array, b, c);
        System.out.println(ans);

        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem-beforeUsedMem;
        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }

    public static int solve(int[] array, int b, int c) {
        //O(n) time | O(1) space
        int sum = 0;
        int len = array.length;
        for (int i = 0; i < b; i++)  // find prefix sum of length b
            sum += array[i];

        // use sliding window approach to find sum of length c with length b.
        int startIdx = 1; // 1 because already calculated the subarray sum of length b in above for loop.
        int endIdx = b;

        while (endIdx < len) {

            sum = sum + array[endIdx] - array[startIdx - 1];   // add array[endIdx] num and remove array[startIdx - 1]
            if (sum == c)   // found subarray of sum c, so return 1.
                return 1;

            startIdx++;
            endIdx++;
        }


        return 0;
    }
}