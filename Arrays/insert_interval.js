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
class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

function insertInterval(intervals, newInterval) {
  const mergedIntervals = [];
  let i = 0;

  // Skip all intervals that end before the new interval starts
  while (i < intervals.length && intervals[i].end < newInterval.start) {
    mergedIntervals.push(intervals[i]);
    i++;
  }

  // Merge intervals that overlap with the new interval
  while (i < intervals.length && intervals[i].start <= newInterval.end) {
    newInterval.start = Math.min(intervals[i].start, newInterval.start);
    newInterval.end = Math.max(intervals[i].end, newInterval.end);
    i++;
  }

  mergedIntervals.push(newInterval);

  // Add the remaining intervals to the merged intervals list
  while (i < intervals.length) {
    mergedIntervals.push(intervals[i]);
    i++;
  }

  return mergedIntervals;
}

// Example usage
const intervals = [new Interval(1, 3), new Interval(6, 9)];
const newInterval = new Interval(2, 5);

console.log("Original intervals:", intervals);
const mergedIntervals = insertInterval(intervals, newInterval);
console.log("Merged intervals:", mergedIntervals);
