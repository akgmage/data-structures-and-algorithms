/**
 * You are given an array A of integers of size N.
 *
 * Your task is to find the equilibrium index of the given array
 *
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 *
 * NOTE:
 *
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 *
 *
 * Input Format
 * First arugment is an array A .
 *
 *
 * Output Format
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 *
 *
 * Example Input
 * Input 1:
 * A=[-7, 1, 5, 2, -4, 3, 0]
 * Input 2:
 *
 * A=[1,2,3]
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Explanation 1:
 *
 * There is no such index.
 */

package PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(-7, 1, 5, 2, -4, 3, 0));
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(ArrayList<Integer> array) {
        // O(N) time | O(N) space
        ArrayList<Integer> prefixSum = new ArrayList<>();

        prefixSum.add(array.get(0));
        for (int i = 1; i < array.size(); i++) {
            int currentPrefixSum = prefixSum.get(i - 1) + array.get(i);
            prefixSum.add(currentPrefixSum);
        }

        for (int i = 0; i < array.size(); i++) {
            if (i == 0 ) {
                if (prefixSum.get(prefixSum.size() - 1) - prefixSum.get(i) == 0) return i;
                continue;
            }
            if (prefixSum.get(i - 1) == prefixSum.get(prefixSum.size() - 1) - prefixSum.get(i))
                return i;
        }
        return -1;
    }
}
