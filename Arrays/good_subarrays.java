/**
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 107
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 *
 *
 * Output Format
 * Return the count of good subarrays in A.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 4
 * Input 2:
 *
 * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 * B = 65
 *
 *
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 *
 * 36
 *
 *
 * Example Explanation
 * Explanation 1:
 * Even length good subarrays = {1, 2}
 * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
 */

public class GoodSubArrays {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        int[] array = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int b = 65;
        int ans = solve(array, b);
        System.out.println(ans);
        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem-beforeUsedMem;
        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }
    public static int solve(int[] array, int b) {
        // O(n^2) time | O(n) space
        int len = array.length;
        int[] prefixArray  = new int[len];
        int ans = 0;

        prefixArray[0] = array[0];
        for (int i = 1; i < len; i++) { // O(n) time | O(n) space for prefix array
            int currentNum = array[i];
            prefixArray[i] = prefixArray[i - 1] + currentNum;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int currentSubArraySize = j - i + 1;
                int currentSubArraySum;

                if (i == 0) currentSubArraySum = prefixArray[j];
                else currentSubArraySum = prefixArray[j] - prefixArray[i - 1];

                if (currentSubArraySize % 2 == 0 && currentSubArraySum < b) ans += 1; //for even
                if (currentSubArraySize % 2 > 0 && currentSubArraySum > b) ans += 1; //for odd

            }
        }
        return ans;
    }
}
