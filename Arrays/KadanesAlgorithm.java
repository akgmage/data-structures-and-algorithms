package FamousAlgorithms;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve1(int[] array) {
        // O(N) time | O(1) space
        // To keep track of max sub-array sum
        int maxSoFar = array[0];
        // To keep track of current max sub-array sum at a particular index
        int maxEndingHere = array[0];

        // Traverse and find the max sub-array sum
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            // either add num to maxEndingHere or initialize maxEndingHere with num.
            maxEndingHere = Math.max(maxEndingHere + num, num);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
    public static int solve(int[] array) {
        // O(N) time | O(1) space
        int currentSum, maxSum;
        currentSum = maxSum = 0;

        for (int num : array) {
            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

}
