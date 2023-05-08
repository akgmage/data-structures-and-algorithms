package SubsequenceAndSubsets;

import java.util.Arrays;

public class CountAllSubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 6, 7, 3, 2};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        // O(LogN + N) time | O(1) space
        int sum = Arrays.stream(arr).sum();

        return ((int) Math.pow(2, arr.length - 1)) * sum;


    }
}
