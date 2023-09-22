public import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int findBoundary(List<Boolean> arr) {
        int low = 0;                // Initialize the low pointer to the beginning of the list.
        int high = arr.size() - 1;  // Initialize the high pointer to the end of the list.
        int bv = -1;                // Initialize bv (boundary value) to -1.

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the middle index.

            if (arr.get(mid) == false) {
                // If the element at the middle index is 'false',
                // it means that the last 'true' value should be on the right side.
                low = mid + 1;  // Move the low pointer to the right of mid.
            } else {
                // If the element at the middle index is 'true',
                // update bv to the current middle index and continue searching on the left side.
                bv = mid;       // Update bv to the current middle index.
                high = mid - 1; // Move the high pointer to the left of mid.
            }
        }

        // The loop ends when low > high, indicating that the search is complete.
        // bv contains the index of the last 'true' value encountered.
        return bv;
    }
}
