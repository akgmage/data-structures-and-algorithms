/*
	Insert Interval

	In this implementation, the `Interval` struct represents an interval with a start and end value.
	The `insert` function takes a sorted list of intervals and a new interval as input and returns a new
	list of intervals after merging the new interval with the existing intervals.

	Here's how the `insert` function works:

	1. It initializes an empty `result` slice to store the merged intervals and sets the index `i` to 0.
	2. It iterates over the existing intervals and adds intervals that end before the new interval starts to the
	`result` slice.
	3. It merges intervals that overlap with the new interval by updating the start and end values of the new
	interval accordingly.
	4. It adds the merged new interval to the `result` slice.
	5. It adds any remaining intervals from the original list to the `result` slice.
	6. Finally, it returns the `result` slice containing the merged intervals.

	The `min` and `max` functions are helper functions to find the minimum and maximum of two integers.

	In the `main` function, an example input is provided with a list of intervals and a new interval.
	The `insert` function is called with these inputs, and the result is printed to the console.

	Time Complexity:
	The time complexity is O(n), where n is the number of intervals in the input list. This is because we need to
	iterate through each interval in the list to merge and insert the new interval. In the worst case, we may
	need to traverse all intervals in the list.

	Space Complexity:
	The space complexity is O(n), where n is the number of intervals in the input list. This is because we
	create a new result slice to store the merged intervals, which can potentially contain all the intervals
	from the input list plus the merged new interval. Therefore, the space required is proportional to the
	number of intervals in the input list.

	Overall, the algorithm has a linear time complexity and linear space complexity with respect to the number
	of intervals in the input list.
*/
import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class InsertInterval {
    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        // Traverse through each interval in the input list
        // and perform the necessary merging and inserting.
        for (Interval interval : intervals) {
            // If the current interval ends before the new interval starts,
            // add it to the result as it does not overlap.
            if (interval.end < newInterval.start) {
                result.add(interval);
            }
            // If the current interval starts after the new interval ends,
            // add the new interval and update it to the current interval
            // as there won't be any more overlap with subsequent intervals.
            else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            }
            // If there is an overlap between the current interval and the new interval,
            // merge them by updating the new interval's start and end.
            else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        // Add the final merged or inserted interval to the result.
        result.add(newInterval);

        return result;
    }

    // Utility function to print the intervals.
    public static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);

        System.out.print("Original intervals: ");
        printIntervals(intervals);

        List<Interval> mergedIntervals = insertInterval(intervals, newInterval);

        System.out.print("Merged intervals: ");
        printIntervals(mergedIntervals);
    }
}
