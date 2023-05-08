import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 *
 * NOTE: The order of the resultant array should be the same as the input array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the count of divisors of each element of the array in the form of an array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 3, 4, 5]
 * Input 2:
 *
 *  A = [8, 9, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 2, 3, 2]
 * Output 1:
 *
 *  [4, 3, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *  So the count will be [2, 2, 3, 2].
 * Explanation 2:
 *
 *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *  So the count will be [4, 3, 4].
 */
public class CountOfDivisors {
    public static void main(String[] args) {
        int[] arr = {3, 52, 66, 64, 14, 51, 6, 39, 5, 26, 80, 88, 60, 73, 67, 16, 1, 81, 62, 42, 83, 31, 40, 4, 32, 31, 44, 3, 20, 94, 93, 57, 2, 18, 32, 59, 91, 30, 45 };
        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] arr) {
        // NLog(N) + NLog(Log(N)) time | O(N) space

        // find the max element
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
        }

        // Build smallest-prime-factor array of size (max of element inf arr)
        int[] spf = getSpf(max);
        int[] res = new int[arr.length];

        int power = 0;
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            ans = 1;
            while (num > 1) {
                int s = spf[num]; // s = 2
                power = 0;
                while (num > 1 && num % s == 0) { // 5 % 2 != 0
                    num = num / s;
                    power++;
                }
                ans = ans*(power + 1);
                res[i] = ans;
            }
        }
        return res;
    }
    public static int[] getSpf(int num) {

        int[] spf = new int[num + 1];
        // set for every element smallest prime factor is element
        for (int i = 2; i <= num; i++) {
            spf[i] = i;
        }

        for (int i = 2; i*i <= num; i++) {

            // if i is prime
            if (spf[i] == i) {
                // start i^2
                for (int j = i*i; j <= num; j+=i) {
                    // for all multiples of i, smallest
                    // prime factor is i.
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;

    }
}
