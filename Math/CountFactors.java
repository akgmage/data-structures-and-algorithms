import java.util.Arrays;

/**
 * Given an integer N, find all the no's from 1 to N.
 * count of factors of the number.
 *
 * Eg:
 * N = 8   --> 1, 2, 3, 4, 5, 6, 7, 8
 * factors --> 1, 2, 2, 3, 2, 4, 2, 4
 *
 */
public class CountFactors {
    public static void main(String[] args) {
        int n = 8;
        int[] ans = solve(n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int n) {
        // time O(NLog(N)) | space O(1)
        int[] factors = new int[n];
        // increment every factor with 1

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                factors[j - 1] += 1;
            }
        }
        return factors;
    }
}
