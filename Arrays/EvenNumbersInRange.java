/**
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
 * For every query, the task is to find the count of even numbers in the range A[B[i][0]…B[i][1]].
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Q <= 105
 * 1 <= A[i] <= 109
 * 0 <= B[i][0] <= B[i][1] < N
 *
 *
 * Input Format
 * First argument A is an array of integers.
 * Second argument B is a 2D array of integers.
 *
 *
 * Output Format
 * Return an array of integers.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [   [0,2]
 *         [1,4]   ]
 * Input 2:
 * A = [2, 1, 8, 3, 9]
 * B = [   [0,3]
 *         [2,4]   ]
 *
 *
 * Example Output
 * Output 1:
 * [1, 2]
 * Output 2:
 * [2, 1]
 *
 *
 * Example Explanation
 * For Input 1:
 * The subarray for the first query is [1, 2, 3] which contains 1 even number.
 * The subarray for the second query is [2, 3, 4, 5] which contains 2 even numbers.
 * For Input 2:
 * The subarray for the first query is [2, 1, 8, 3] which contains 2 even numbers.
 * The subarray for the second query is [8, 3, 9] which contains 1 even number.
 */
package PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;

public class EvenNumbersInRange {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 8, 3, 9));
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add((ArrayList<Integer>) Arrays.asList(0, 3));
        b.add((ArrayList<Integer>) Arrays.asList(2, 4));
        ArrayList<Integer> ans = solve(arr, b);
        System.out.println(ans);
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array, ArrayList<ArrayList<Integer>> B) {
         //O(Q*N) time | O(N) space

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> evenPrefixSum = new ArrayList<>();

        evenPrefixSum.add(0);
        if (array.get(0) % 2 == 0) evenPrefixSum.set(0, evenPrefixSum.get(0) + 1);

        for (int i = 1; i < array.size(); i++) {
            evenPrefixSum.add(i, evenPrefixSum.get(i - 1));
            int num = array.get(i);
            if (num % 2 == 0) evenPrefixSum.set(i, evenPrefixSum.get(i - 1) + 1);
        }

        for (ArrayList<Integer> query : B) {
            int startIdx = query.get(0);
            int endIdx = query.get(1);
            if (startIdx == 0) result.add(evenPrefixSum.get(endIdx));
            else result.add(evenPrefixSum.get(endIdx) - evenPrefixSum.get(startIdx - 1));
        }
        return result;
    }
}
