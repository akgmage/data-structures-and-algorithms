/**
 * Problem Description
 * Given an unsorted integer array, A of size N. Find the first missing positive integer.
 *
 * Note: Your algorithm should run in O(n) time and use constant space.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the first missing positive integer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1, 2, 0]
 * Input 2:
 *
 * [3, 4, -1, 1]
 * Input 3:
 *
 * [-8, -7, -6]
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 2
 * Output 3:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [1, 2, 0]
 * First positive integer missing from the array is 3.
 */

package Linear.Arrays.InterviewProblems;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,1,0,4,0};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
//        boolean exists = false;
//        for (int i = 1; i <= array.length; i++) {
//            exists = false;
//            for (int k : array) {
//                if (k == i) {
//                    exists = true;
//                    break;
//                }
//            }
//            if (!exists) {
//                return i;
//            }
//        }
//        return array.length + 1;

        // Hash Set
//        HashSet<Integer> hs = new HashSet<>();
//        for (int num : array) {
//            hs.add(num);
//        }
//        for (int i = 1; i <= array.length; i++) {
//            if (!hs.contains(i)) return i;
//        }
//        return array.length + 1;


//        Arrays.sort(array);
//        int prev = 0;
//
//        for (int curr : array) {
//            if (curr < 0 || curr == 0 || prev == curr) {
//                continue;
//            }
//            if (prev + 1 != curr) return prev + 1;
//            prev = curr;
//        }
//        return prev + 1;

        // First find elements which are not equal to i + 1, then swap

        for (int i = 0; i < array.length; i++) {

            // keep swapping until array[i] = array[i+1]
            while (array[i] > 0 && array[i] <= array.length && array[i] != i+1) {
                int val = array[i];
                if (array[i] == array[val-1]) break;
                swap(i,val-1, array);
            }
        }

        // iterate and find val where array[i] != array[i+1]

        for (int i = 0; i < array.length; i++) {
            if(array[i] != i + 1) return i + 1;
        }
        return array.length + 1;
    }
    public static void swap(int i, int j,int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
