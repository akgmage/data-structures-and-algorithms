import java.util.Arrays;

/**
 * Given an integer N
 * find the smallest prime factor for
 * all no's from 1 to N.
 */
public class SmallestPrimeFactor {
    public static void main(String[] args) {
        int n = 5;
        int[] ans = solve(n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int n) {
        int[] smallestPrimeFactor = new int[n + 1];

        // for every element set num as smallest prime factor

        for (int i = 2; i <= n; i++) {
            smallestPrimeFactor[i] = i;
        }

        for (int i = 2; i*i <= n; i++) {

            // if i is prime
            if (smallestPrimeFactor[i] == i) {

                for (int j = i*i; j <= n; j += i) {

                    // if it is not prime set to i as smallest prime factor
                    if (smallestPrimeFactor[j] == j) {
                        smallestPrimeFactor[j] = i;
                    }
                }
            }
        }
        return Arrays.copyOfRange(smallestPrimeFactor, 2, smallestPrimeFactor.length);
    }
}
