/**
 * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the common elements.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 2, 1]
 *  B = [2, 3, 1, 2]
 * Input 2:
 *
 *  A = [2, 1, 4, 10]
 *  B = [3, 6, 2, 10, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 2]
 * Output 2:
 *
 *  [2, 10]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 * Explantion 2:
 *
 *  Elements (2, 10) appears in both the array.
 */

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountElements {
    public static void main(String[] args) {
        int[] array1 = {2, 1, 4, 10, 10};
        int[] array2 = {3, 6, 2, 10, 10, 10};

        int[] res = solve(array1, array2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solve(int[] array1, int[] array2) {
        // O(N + M) time | O(N + M) space

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        for (int num : array1) {
            hashMap1.put(num, hashMap1.getOrDefault(num, 0) + 1);
        }

        for (int num : array2) {
            hashMap2.put(num, hashMap2.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int key: hashMap1.keySet()) {

            if (hashMap2.containsKey(key)) {

                for (int i = 0; i < Math.min(hashMap1.get(key), hashMap2.get(key)); ++i) { // to get common elements
                    res.add(key);
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();

    }
}

