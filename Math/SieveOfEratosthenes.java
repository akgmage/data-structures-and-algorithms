import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 49;
        int[] primes = solve(n);
        System.out.println(Arrays.toString(primes));
    }
    public static int[] solve(int n) {
        // time O(N(Log(LogN))) | space O(1)
        ArrayList<Integer> ans = new ArrayList<>();
        int[] primes = sieve(n);
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public static int[] sieve(int n) {
        int[] primes = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {

            // check ith element is prime or not
            if (primes[i] == 0) {
                for (int j = i*i; j <= n; j += i) {
                    // make every multiple of j false i.e 1
                    primes[j] = 1;
                }
            }
        }
        return primes;
    }
}
