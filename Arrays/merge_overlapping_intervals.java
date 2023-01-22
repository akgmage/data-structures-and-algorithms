import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *

 Write a function that takes in a non-empty array of arbitrary intervals, merges any overlapping intervals, and returns the new intervals in no particular order.

 Each interval interval is an array of two integers, with interval[0] as the start of the interval and interval[1] as the end of the interval.

 Note that back-to-back intervals aren't considered to be overlapping. For example, [1, 5] and [6, 7] aren't overlapping; however, [1, 6] and [6, 7] are indeed overlapping.

 Also note that the start of any particular interval will always be less than or equal to the end of that interval.
 Sample Input

 intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]

 Sample Output

 [[1, 2], [3, 8], [9, 10]]
 // Merge the intervals [3, 5], [4, 7], and [6, 8].
 // The intervals could be ordered differently.


 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2},
                {3, 7},
                {4, 7},
                {6, 8},
                {9, 10}};
        int[][] result = solve(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] solve(int[][] intervals) {
        // O(nlog(n)) time | O(n) space
        //Sort the intervals by starting value.
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval : sortedIntervals) {
            int currentIntervalEnd = currentInterval[0];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}





