/**
 * Problem Description
 * Given a collection of intervals, merge all overlapping intervals.
 *
 *
 *
 * Problem Constraints
 * 1 <= Total number of intervals <= 100000.
 *
 *
 *
 * Input Format
 * First argument is a list of intervals.
 *
 *
 *
 * Output Format
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1,3],[2,6],[8,10],[15,18]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1,6],[8,10],[15,18]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merge intervals [1,3] and [2,6] -> [1,6].
 * so, the required answer after merging is [1,6],[8,10],[15,18].
 * No more overlapping intervals present.
 */
package InterviewProblems;

import java.util.*;

public class MergeOverlappingIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args) {
//        int[][] intervals = {{1,2}, {3,5}, {4, 7}, {6, 8}, {9, 10}};

//        int[][] ans = solve(intervals);
//        System.out.println(Arrays.deepToString(ans));
        ArrayList<Interval> intervals= new ArrayList<>();

        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        ArrayList<Interval> ans = merge(intervals);

        for (Interval interval : ans) {
            System.out.println("[" + interval.start + "," + interval.end + "]");

        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end = o2.end;
            }
        });

        Interval currentInterval = intervals.get(0);

        ans.add(currentInterval);

        for (Interval nextInterval : intervals) {
            int currentIntervalEnd = currentInterval.end;
            int nextIntervalStart = nextInterval.start;
            int nextIntervalEnd = nextInterval.end;

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval.end = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                ans.add(currentInterval);
            }
        }
        return ans;

    }
    public static int[][] solve(int[][] intervals) {
        int[][] sortedIntervals = intervals.clone();

        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInterval = sortedIntervals[0];
        List<int[]> mergedIntervals = new ArrayList<int[]>();

        mergedIntervals.add(currentInterval);

        for (int[] nextInterval: sortedIntervals) {
                int currentIntervalEnd = currentInterval[1];
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
