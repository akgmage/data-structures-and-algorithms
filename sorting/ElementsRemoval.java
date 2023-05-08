package Sorting;

import java.util.Arrays;

public class ElementsRemoval {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, -3};
        int res = solve(arr);
        System.out.println(res);
    }
    public static int solve(int[] arr) {

        int res = 0, len = arr.length;

        // O(NLog(N) | O(1) time
        Arrays.sort(arr);


        for (int i = 0; i < len; i++) {
            int currentNum = arr[i];
            res += currentNum * (len - i);
        }
        return res;
    }
}
