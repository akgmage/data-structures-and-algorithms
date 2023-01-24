import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(solve(100));
    }

    public static ArrayList solve(int num) {
        boolean[] prime = new boolean[num + 1];
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= num; p++) {

            // If prime[p] is not changed, then it is prime.
            if (prime[p] == true) {

                // Update all multiples of p greater than or equal to the square of it.
                // numbers which are multiple of p and are less than p^2 are already been marked.
                for (int i = p * p; i <= num; i += p)
                    prime[i] = false;
//
            }
        }
        for (int p = 2; p <= num; p++) {
            if (prime[p]) result.add(p);
        }
        return result;
    }

    /**
     *  boolean[] notPrime = new boolean[n];
     *         int count = 0;
     *         for (int i = 2; i < n; i++) {
     *             if (notPrime[i] == false) {
     *                 count++;
     *                 for (int j = 2; i*j < n; j++) {
     *                     notPrime[i*j] = true;
     *                 }
     *             }
     *         }
     *
     *         return count;
     *     }
     */
}
