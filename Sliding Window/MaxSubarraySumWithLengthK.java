package SlidingWindow;

public class MaxSubarraySumWithLengthK {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        int[] array = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int targetLength = 5;
        int ans = solve(array, targetLength);
        System.out.println(ans);

        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem-beforeUsedMem;
        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }
    public static int solve(int[] array, int targetLength) {
        // O(n) time | O(1) space
        int maxSubarraySum = 0;
        int currentSum = 0;
        int length = array.length;

        for (int i = 0; i < targetLength; i++)
             currentSum += array[i];

        int startIdx = 1;
        int endIdx = targetLength;

        while (endIdx < length) {
            currentSum = currentSum + array[endIdx++] - array[startIdx++ - 1];
            maxSubarraySum = Math.max (maxSubarraySum, currentSum);
        }
        return maxSubarraySum;
    }
}
