/**
 * Problem Description
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 * 0 <= |intervals| <= 105
 *
 *
 *
 * Input Format
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 * Return the vector of intervals after merging
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 * Output 2:
 *
 *  [ [1, 9] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 */

package InterviewProblems;

import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

        intervals.add(new ArrayList<>());
        intervals.add(new ArrayList<>());

        intervals.get(0).add(1);
        intervals.get(0).add(3);

        intervals.get(1).add(6);
        intervals.get(1).add(9);

        ArrayList<Integer> mergeInterval = new ArrayList<>();
        mergeInterval.add(2);
        mergeInterval.add(5);

        ArrayList<ArrayList<Integer>> ans = solve(intervals, mergeInterval);

        System.out.println(ans);
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> interval) {
        // O(N) time | O(N) space
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {

            ArrayList<Integer> currentInterval = intervals.get(i);

            int currentIntervalStart = currentInterval.get(0);
            int currentIntervalEnd = currentInterval.get(1);

            int intervalStart = interval.get(0);
            int intervalEnd = interval.get(1);

            //  currentInterval in the intervals

            if (currentIntervalEnd < intervalStart) {

                // Non-Overlapping-Interval
                ans.add(currentInterval);
            } else if (currentIntervalStart > intervalEnd) {
                // Non-Overlapping-Interval
                ans.add(interval);

                // add remaining intervals to ans
                for (int j = i; j < intervals.size(); j++) {
                    ans.add(intervals.get(j));
                }
                return ans;
            } else {
                // Overlapping
                // Merge currentInterval with interval
                interval.set(0, Math.min(interval.get(0), currentIntervalStart));
                interval.set(1, Math.max(interval.get(1), currentIntervalEnd));
            }

        }
        ans.add(interval);
        return ans;
    }
}
