import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *
 * and at least one occurrence of the minimum value of the array.
 *
 Example Input
 Input 1:

 A = [1, 3]
 Input 2:

 A = [2]


 Example Output
 Output 1:

 2
 Output 2:

 1


 Example Explanation

 Explanation 1:

 Only choice is to take both elements.
 Explanation 2:

 Take the whole array.
 */

public class ClosestMinMax {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1));
        System.out.println(solve(array));
    }
    public static int solve(ArrayList<Integer> array) {

        // Find Min, Max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (var num : array) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        if (min == max) return 1; // If array contains all same elements.

        // Find the closest range between Min and Max
        int currentMinIdx = -1;
        int currentMaxIdx = -1;
        int closetMinMaxLength = array.size();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            if (num == min) {
                currentMinIdx = i;
                if (currentMaxIdx != -1) {
                    closetMinMaxLength = Math.min(closetMinMaxLength, currentMinIdx - currentMaxIdx + 1);
                }
            }
            if (num == max) {
                currentMaxIdx = i;
                if (currentMinIdx != -1) {
                    closetMinMaxLength = Math.min(closetMinMaxLength, currentMaxIdx - currentMinIdx + 1);
                }
            }
        }

        return closetMinMaxLength;
    }
}
