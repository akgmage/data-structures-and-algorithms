/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * 2 <= B, C <= 40000
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is an integer B.
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = 4
 *  B = 2
 *  C = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1st magical number is 2.
 * Explanation 2:
 *
 *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
package Searching;

public class AthMagicalNumber {
    public static void main(String[] args) {
        int a = 807414236, b = 3788, c = 38141;
        int ans = solve(a, b, c);
        System.out.println(ans);
    }
    public static int solve(int a, int b, int c) {
        // O(Log(a*min(b,c))) time | O(1) space

        long left = Math.min(b, c); // or simply min = 1
        long right = (long) a * Math.min(b, c);
        long ans = 0;
        long mod = (long) 1e9 + 7;

        long lcm = getLcm(b, c);
        System.out.println(lcm);

        while (left <= right) {
            long middle = left + (right - left)/2;
            long magicalNumsCount = getMagicalNumsCount(b, c, middle, lcm);

            if (magicalNumsCount == a) {
                ans = middle;
                right = middle - 1;
            } else if (magicalNumsCount > a) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } return (int) (ans % mod);
    }
    public static int getLcm(int a, int b) {

        /**
         * lcm(a, b) * gcd(a, b) = a * b
         * lcm(a, b) = (a * b) / gcd(a, b)
         */

        int divisor = a;
        int divident = b;
        while (divident % divisor != 0) {
            int reminder = divident % divisor;
            divident = divisor;
            divisor = reminder;
        }
        int gcd = divisor;

        return (a * b) / gcd; // return lcm
    }
    public static long getMagicalNumsCount(long a, long b, long middle, long lcm) {

        return ( (middle/a) + (middle/b) - (middle/lcm) );
    }
}
