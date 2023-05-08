/**
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= 107
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of subarrays in A having sum less than B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, 6]
 *  B = 10
 * Input 2:
 *
 *  A = [1, 11, 2, 3, 15]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 * Explanation 2:
 *
 *  The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class CountingSubArrays {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem-beforeUsedMem;

        int[] array = {1, 11, 2, 3, 15};
        int b = 10;
        int ans = solve(array, b);
        System.out.println(ans);


        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }
    public static int solve(int[] array, int b) {
        int ans = 0;
        int len = array.length;
        int[] prefixSum  = new int[len];
        prefixSum[0] = array[0];

        for (int i = 1; i < len; i++) prefixSum[i] = prefixSum[i - 1] + array[i];

        for(int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int currentSubArraySum = prefixSum[j];
                if (i > 0) currentSubArraySum -= prefixSum[i - 1];

                if (currentSubArraySum < b) ans++;
            }
        }
        return ans;
    }

}
