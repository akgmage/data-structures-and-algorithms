/**
 * Given two arrays of integers with equal lengths, return the maximum value of:
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * Example 2:
 *
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 *
 *
 * Constraints:
 *
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 */
package BasicMaths;

public class MaximumOfAbsoluteValueExpression {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {-1, 4, 5, 6};

        int ans = solve(arr1, arr2);
        System.out.println(ans);
    }
    public static int solve(int[] arr1, int[] arr2) {
        /**
         *  abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B)
         *
         *
         * 1. arr1[i] - arr1[j] + arr2[i] - arr2[j] + i - j   -->   (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)
         * 2. arr1[i] - arr1[j] + arr2[i] - arr2[j] - i + j   -->   (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j] - j)
         *
         * 3. arr1[i] - arr1[j] - arr2[i] + arr2[j] + i - j   -->   (arr1[i] - arr2[i] + i) - (arr1[j] + arr2[j] + j)
         * 4. arr1[i] - arr1[j] - arr2[i] + arr2[j] - i + j   -->   (arr1[i] - arr2[i] - i) - (arr1[j] + arr2[j] - j)
         *
         * 5. -arr1[i] + arr1[j] + arr2[i] - arr2[j] + i - j   --> -(arr1[i] - arr2[i] - i) + (arr1[j] - arr2[j] - j)
         * 6. -arr1[i] + arr1[j] + arr2[i] - arr2[j] - i + j   --> -(arr1[i] - arr2[i] + i) + (arr1[j] - arr2[j] + j)
         *
         * 7. -arr1[i] + arr1[j] - arr2[i] + arr2[j] + i - j   --> -(arr1[i] + arr2[i] - i) + (arr1[j] + arr2[j] - j)
         * 8. -arr1[i] + arr1[j] - arr2[i] + arr2[j] - i + j   --> -(arr1[i] + arr2[i] + i) + (arr1[j] + arr2[j] + j)
         *
         *
         * 1 & 8 ; 2 & 7; 3 & 6; 4 & 5 are practically the same.
         * So , problem reduces to finding max of (1,2,3,4).
         * And in each 1,2,3,4, values in both brackets are same, so we simply find max(value in bracket) - min(value in bracket) for each.
         * Then find max of values obtained from (1,2,3,4)
         */


        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;

        int n = arr1.length;

        for (int i = 0; i < n; i++) {
            //1st scenario arr1[i] + arr2[i] + i
            max1 = Math.max(arr1[i] + arr2[i] + i, max1);
            min1 = Math.min(arr1[i] + arr2[i] + i, min1);

            //2nd scenario arr1[i] + arr2[i] - i
            max2 = Math.max(arr1[i] + arr2[i] - i, max2);
            min2 = Math.min(arr1[i] + arr2[i] - i, min2);

            //3rd scenario arr1[i] - arr2[i] - i
            max3 = Math.max(arr1[i] - arr2[i] - i, max3);
            min3 = Math.min(arr1[i] - arr2[i] - i, min3);

            //4th scenario arr1[i] - arr2[i] + i
            max4 = Math.max(arr1[i] - arr2[i] + i, max4);
            min4 = Math.min(arr1[i] - arr2[i] + i, min4);

        }
        int diff1 = max1 - min1;
        int diff2 = max2 - min2;
        int diff3 = max3 - min3;
        int diff4 = max4 - min4;

        return Math.max(Math.max(diff1, diff2), Math.max(diff3, diff4));
    }
}
