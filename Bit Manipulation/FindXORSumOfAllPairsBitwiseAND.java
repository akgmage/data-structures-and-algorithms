/**
 * Problem Statement
 *
 * Calculate the sum of XOR of all pairs
 */
package BitManipulation;

public class FindXORSumOfAllPairsBitwiseAND {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 8, 2};

        int ans = solve(arr);
        System.out.println(ans);
    }

    public static int solve(int[] arr) {
        // O(N) time | O(1) space
        int ans = 0;
        for (int i = 0; i < 31; i++) { //  32 bit number

            int setBitSCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (isSetBit(arr[j], i)) {
                    setBitSCount++;
                }
            }
            ans += setBitSCount * (arr.length - setBitSCount) * (int) Math.pow(2, i);
//            ans += setBitSCount * (arr.length - setBitSCount) * (1 << i);
        }

        return 2 * ans;
    }

    public static boolean isSetBit (int a, int i) {
        return (a & (1 << i) )!= 0;
    }
}
