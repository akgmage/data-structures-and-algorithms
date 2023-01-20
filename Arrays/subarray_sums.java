import java.util.ArrayList;
import java.util.Arrays;

/**
 * ou are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Ai <= 10 4
 *
 *
 * Input Format
 * The first argument is the integer array A.
 *
 *
 * Output Format
 * Return a single integer denoting the sum of all subarray sums of the given array.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 *
 * A = [2, 1, 3]
 *
 *
 * Example Output
 * Output 1:
 * 20
 * Output 2:
 *
 * 19
 *
 *
 * Example Explanation
 * Explanation 1:
 * The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
 * Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
 * Explanation 2:
 *
 * Similiar to the first example, the sum of all subarray sums for this array is 19.
 */
public class SubarraysSum {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(2, 9, 5 )
        );
        System.out.println(solve(array));
    }
    public static long solve(ArrayList<Integer> array) {
        long totalSubarraysSum = 0;

        // Build prefix array : O(n) time | O(n) space
//        ArrayList<Integer> prefixSum = new ArrayList<>();
//        prefixSum.add(array.get(0));
//        for (int i = 1; i < array.size(); i++) {
//            int currentNum = array.get(i);
//            int currentPrefixSum = prefixSum.get(i - 1) + currentNum;
//            prefixSum.add(currentPrefixSum);
//        }
        // Sum all subArrays
//        for (int i = 0; i < array.size(); i++) {
//            for (int j = i; j < array.size(); j++) {
//                if (i == 0) totalSubarraysSum += prefixSum.get(j);
//                else totalSubarraysSum += prefixSum.get(j) - prefixSum.get(i - 1);
//            }
//        }
        // Without prefix array O(n) time | O(1) space
//        long totalSubarraySum = 0;
//        for (int i = 0; i < array.size(); i++) {
//            int currentSum = 0;
//            for (int j = i; j < array.size(); j++) {
//                currentSum += array.get(j);
//                totalSubarraysSum += currentSum;
//            }
//        }

        // No.of subarrays = (i + 1) * (N - i); i is starting index.
        // Optimal O(n) time | O(1) space solution
        for (int i = 0; i < array.size(); i++) {
            long currentSubarraySum = (long) (i + 1) * (array.size() - i) * array.get(i);
            totalSubarraysSum += currentSubarraySum;
        }
        return totalSubarraysSum;
    }
}
