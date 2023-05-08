package Subarrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array A of length N, return the subarray from B to C.
 */
public class RangeSubarrays {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(4, 3, 2, 6));
        int B = 1;
        int C = 3;
        System.out.println(solve(array, B, C));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array, int B, int C) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = B; i <= C; i++) {
            Integer num = array.get(i);
            result.add(num);
        }
        return result;
    }
}
