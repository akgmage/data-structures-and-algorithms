/**
 * Problem Description
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of GCD.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [12, 15, 18]
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  15
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 * Explanation 2:
 *
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
public class DeleteOne {
    public static void main(String[] args) {
        int[] array = {12, 15, 18};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        int[] prefixGcd = new int[array.length];
        int[] suffixGcd = new int[array.length];

        prefixGcd[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixGcd[i] = findGcd(prefixGcd[i-1], array[i]);
        }

        suffixGcd[array.length - 1] = array[array.length - 1];

        for (int i = array.length - 2; i > -1; i--) {
            suffixGcd[i] = findGcd(suffixGcd[i + 1], array[i]);
        }
        // try deleting all the no's 1 by 1.
       int ans = 0;
        for (int i = 0; i < array.length; i++) {

            //deleting ith-index

            // i = 0, edge-case
            int left, right;
            if (i == 0) {
                left = prefixGcd[0];
            } else {
                left = prefixGcd[i-1];
            }
            // i = array.length - 1, edge-case
            if (i == array.length - 1) {
                right = 0;
            } else {
                right = suffixGcd[array.length - 1] - suffixGcd[i + 1 - 1];
            }
            ans = Math.max(ans, findGcd(left, right));

        }

        return ans;
    }
    public static int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }
}
