package Searching;

public class FindFrequencyOfk {
    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 71, 73};
        int[] finalRange = {-1, -1};
        int target = 45;
        solve(array, target, 0, array.length - 1, finalRange, true);
        solve(array, target, 0, array.length - 1, finalRange, false);
        System.out.println(finalRange[1] - finalRange[0] + 1);
    }
    public static void solve(int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
        // O(LogN) time | O(1) space

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                // find left extremity
                if (goLeft) {
                    if (mid == 0 || array[mid-1] != target) {
                        finalRange[0] = mid;
                        return;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // find right extremity
                    if (mid == array.length - 1 || array[mid+1] != target) {
                        finalRange[1] = mid;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }
}
