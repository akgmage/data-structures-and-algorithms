/**
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exists in the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 5*105
 * 1 <= num[i] <= 109
 *
 *
 * Input Format
 * Only argument is an integer array.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * [2, 1, 2]
 *
 *
 * Example Output
 * 2
 *
 *
 * Example Explanation
 * 2 occurs 2 times which is greater than 3/2.
 */

package InterviewProblems;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        int len = arr.length;

        // Boyer–Moore majority vote algorithm
        int count = 0;
        int maxNum = 0;
        for (int num: arr)  {
             if (count == 0) {
                maxNum = num;
                count = 1;
            } else if (maxNum == num) {
                count++;
            } else count--;
        }
        count = 0;
        // Check if the maxNum count > n / 2
        for (int i = 0; i < len; i++) {
            int currentNum = arr[i];
            if (currentNum == maxNum) count++;
        }
        if (count > len / 2) return maxNum; // Majority exists
        return -1;

        // Using HashMap O(N) time O(N) space
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < len; i++) {
//            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
//        }
//        for (int val : hashMap.keySet()) {
//            if (hashMap.get(val) > arr.length / 2) return val;
//        }

        // Using sorting NLog(N)
//         Arrays.sort(arr);
//         return arr[arr.length / 2];

//        return ans;
    }
}
