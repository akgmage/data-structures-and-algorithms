/**
 * You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
 * The cost of these trees is Bp + Bq + Br.
 *
 * You are to choose 3 trees such that their total cost is minimum. Return that cost.
 *
 * If it is not possible to choose 3 such trees return -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= A[i], B[i] <= 109
 * 3 <= size(A) = size(B) <= 3000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer array B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 5]
 *  B = [1, 2, 3]
 * Input 2:
 *
 *  A = [1, 6, 4, 2, 6, 9]
 *  B = [2, 5, 7, 3, 2, 7]
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
 * Explanation 2:
 *
 *  We can choose the trees with indices 1, 4 and 5, and the cost is 2 + 3 + 2 = 7.
 *  This is the minimum cost that we can get.
 */

package InterviewProblems;

public class ChristmasTrees {
    public static void main(String[] args) {
        int[] a = {1, 6, 4, 2, 6, 9};
        int[] b = {2, 5, 7, 3, 2, 7};

        int ans = solve(a, b);
        System.out.println(ans);
    }

    public static int solve(int[] a, int[] b) {
        // O(N^2) time | O(1) space
            int ans = Integer.MAX_VALUE;
            int len = a.length;
            for (int j = 1; j < len; j++) {
                int tempSum = b[j], iVal = Integer.MAX_VALUE, kVal = Integer.MAX_VALUE;
                for (int i = j - 1; i > -1; i--) {
                    if (a[i] < a[j] && b[i] < iVal) iVal = b[i];
                }
                for (int k = j + 1; k < len; k++) {
                    if (a[k] > a[j] && b[k] < kVal) kVal = b[k];
                }
                if (iVal != Integer.MAX_VALUE && kVal != Integer.MAX_VALUE) {
                    tempSum = tempSum + iVal + kVal;
                    ans = Math.min(tempSum, ans);
                }
            }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
