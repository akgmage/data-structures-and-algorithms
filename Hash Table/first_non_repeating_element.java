package Hashing;

import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int[] array = {10, 5, 3, 4, 3, 5, 6};

        int res = solve(array);
        System.out.println(res);
    }
    public static int solve(int[] array) {
        // O(N) time | O(N) space where N is length of array

        // Build HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : array) {

            if (!hashMap.containsKey(num)) hashMap.put(num, 0);
            hashMap.put(num, hashMap.get(num) + 1);
        }

        for (int num : array) {
            if (hashMap.get(num) == 1) return num;
        }

        return -1;
    }
}
