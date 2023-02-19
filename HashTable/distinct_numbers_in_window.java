/**
 * Problem Description
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 *
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 *
 * NOTE: if B > N, return an empty array.
 *
 *
 *
 * Input Format
 * First argument is an integer array A
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 1, 3, 4, 3]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 1, 2, 2]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3, 3, 2]
 * Output 2:
 *
 *  [1, 1, 1, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A=[1, 2, 1, 3, 4, 3] and B = 3
 *  All windows of size B are
 *  [1, 2, 1]
 *  [2, 1, 3]
 *  [1, 3, 4]
 *  [3, 4, 3]
 *  So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 *
 *  Window size is 1, so the output array is [1, 1, 1, 1].
 */
package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 4, 3};
        int k = 3;

        int[] res = solve(array, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int[] array, int k) {
        // O(N) time O(N) space
        ArrayList<Integer> arrayList = new ArrayList<>();


        // Build HashMap for the first Window i.e length k
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }

        arrayList.add(hashMap.size());

        int start = 1, end = k;
        while (end < array.length) {
                //Incoming
              if (hashMap.containsKey(array[end])) {
                  // Increase Frequency
                  hashMap.put(array[end], hashMap.get(array[end]) + 1);
              } else {
                  hashMap.put(array[end], 1);
              }

              //Outgoing
             // Decrease frequency
             hashMap.put(array[start - 1], hashMap.get(array[start - 1]) - 1);

              // check freq
            if (hashMap.get(array[start - 1]) == 0) {
                hashMap.remove(array[start - 1]);
            }
            // add size to res
            arrayList.add(hashMap.size());
            start++;
            end++;
        }
        // O(N^2) time | O(N) space
//        for (int i = 0; i < array.length - k + 1; i++) {
//            HashSet<Integer> hashSet = new HashSet<>();
//            for (int j = i; j < i + k; j++) {
//                hashSet.add(array[j]);
//            }
//            arrayList.add(hashSet.size());
//        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
