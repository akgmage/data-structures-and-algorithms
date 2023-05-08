package Searching;

public class SortedInsertPosition {
    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 6};
        int target = 104;
        int ans = solve(array, target);
        System.out.println(ans);
    }
    public static int solve(int[] array, int targetMatch) {

        int left = 0;
        int right = array.length - 1;
        int n = array.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int potentialMatch = array[mid];

            if (potentialMatch == targetMatch) {
                return mid;
            }

            if (potentialMatch < targetMatch) {
                if (mid == n-1) {
                    return n;
                }
                if (array[mid+1] > targetMatch) {
                    return mid+1;
                } else {
                    left = mid + 1;
                }
            }

            if (potentialMatch > targetMatch) {
                if (mid == 0) {
                    return 0;
                }
                if (array[mid-1] < targetMatch) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
