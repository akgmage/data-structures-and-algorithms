/**
 * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 4, 3]
 * Input 2:
 * A = [2, 1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 1
 *
 *
 * Example Explanation
 * For Input 1:
 * The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
 * For Input 2:
 *
 * The triplet that satisfy the conditions is [1, 2, 3].
 */

package InterviewProblems;

public class CountIncreasingTriplets {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        int[] array = {1, 2, 4, 3};
        int ans = solve(array);
        System.out.println(ans)
        ;
        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem-beforeUsedMem;
        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }
    public static int solve(int[] array) {
        // O(N^2 time | O(1) space
        int totalPairs = 0;
        int len = array.length;
        for (int midIdx = 1; midIdx < len - 1; midIdx++) {
            int midNum = array[midIdx];
            int leftCount = 0;
            for (int leftIdx = midIdx - 1; leftIdx > -1; leftIdx--) {
                int leftNum = array[leftIdx];
                if (leftNum < midNum) leftCount++;
            }
            int rightCount = 0;
            for (int rightIdx = midIdx + 1; rightIdx < len; rightIdx++) {
                int rightNum = array[rightIdx];
                if (rightNum > midNum) rightCount++;
            }
            int currentPairs = leftCount * rightCount;
            totalPairs += currentPairs;
        }
        return totalPairs;
    }
    public static int solveUsingBruteForce(int[] array) {
        // O(N^3) time | O(1) space
        int ans = 0;
        int len = array.length;
        for (int leftIdx = 0; leftIdx < len; leftIdx++) {
            int lefNum = array[leftIdx];
            for (int midIdx = leftIdx + 1; midIdx < len; midIdx++) {
                int middleNum = array[midIdx];
                if (lefNum >= middleNum) continue;
                for (int rightIdx = midIdx + 1; rightIdx < len; rightIdx++) {
                    int rightNum = array[rightIdx];
                    if (middleNum < rightNum) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
