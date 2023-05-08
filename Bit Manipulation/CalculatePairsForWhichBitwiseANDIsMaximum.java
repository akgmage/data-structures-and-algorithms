
/**
 * Problem Description
 * Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 *
 * Output Format
 * Return a single integer that is the maximum A[i] & A[j].
 *
 *
 * Example Input
 * Input 1:-
 * A = [53, 39, 88]
 * Input 2:-
 * A = [38, 44, 84, 12]
 *
 *
 * Example Output
 * Output 1:-
 * 37
 * Output 2:-
 * 36
 *
 *
 * Example Explanation
 * Explanation 1:-
 * 53 & 39 = 37
 * 39 & 88 = 0
 * 53 & 88 = 16
 * Maximum among all these pairs is 37
 * Explanation 2:-
 * Maximum bitwise and among all pairs is (38, 44) = 36
 *
 *
 *
 * See Expected Output
 * Java 8 (Array Support)
 */
package BitManipulation;

public class CalculatePairsForWhichBitwiseANDIsMaximum {
    public static void main(String[] args) {
        int[] arr = {53, 39, 88};

        int ans = solve(arr);
        System.out.println(ans);
    }

    public static int solve(int[] arr) {
        int ans = 0;

        for (int i = 30; i > -1; i--) {
            int setBitsCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (isSetBit(arr[j], i)) {
                    setBitsCount++;
                }
            }

            if (setBitsCount >= 2) {
                // we can pick a pair for which
                // ith bit in ans will be set.

                // Discard all elements with ith bit is 0
                for (int j = 0; j < arr.length; j++) {
                    if (!isSetBit(arr[j], i)) {
                        arr[j] = 0; //remove the array element for which ans bit isn't set
                    }
                }
            }
        }


        //count pairs
        for (int j : arr) {
            if (j != 0) ans++;
        }
        return ((ans * (ans - 1)) / 2);
    }
    public static boolean isSetBit(int a, int i) {
        return (a & (1 << i)) != 0;
    }
}
