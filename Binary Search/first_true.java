public import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int findBoundary(List<Boolean> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int bv = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) == false) {
                low = mid + 1;
            } else {
                bv = mid;
                high = mid - 1;
            }
        }
        return bv;
    }
}
