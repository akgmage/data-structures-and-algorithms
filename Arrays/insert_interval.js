/*
	Problem definition:
		You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent 
		the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
		You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
		
		Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

	Approach:
		The approach used here is to first add all the intervals before the newInterval to the result array.
		Then, we merge overlapping intervals by iterating through the intervals array and comparing the start and end times of the newInterval and the current interval.
		After all overlapping intervals have been merged, we add the newInterval to the result array and then add all the remaining intervals after the newInterval.
		The resulting array will be sorted in ascending order by start time.

	Complexity:
		Time Complexity: O(n), where n is the length of intervals array.
		We iterate through the intervals array only once in the worst case.
		Space Complexity: O(n), where n is the length of intervals array.
		We use an array to store the result, which could potentially contain all the intervals.

	Sample input/outputs:
		Example 1:
		Input:
		intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
		newInterval = [4,8]

		Output:
		[[1,2],[3,10],[12,16]]
		
		Example 2:
		Input:
		intervals = [[1,3],[6,9]]
		newInterval = [2,5]

		Output:
		[[1,5],[6,9]]
		
		Example 3:
		Input:
		intervals = [[1,5]]
		newInterval = [2,3]
		
		Output:
		[[1,5]]
*/

const insert = function(intervals, newInterval) {
    const result = [];
    let i = 0;

    // Add all the intervals before the newInterval
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
		result.push(intervals[i]);
		i++;
    }

    // Merge overlapping intervals
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
		newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
		newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
		i++;
    }

    result.push(newInterval);

    // Add all the intervals after the newInterval
    while (i < intervals.length) {
		result.push(intervals[i]);
		i++;
    }

    return result;
};

console.log("The resulting array of intervals is:");
console.log(insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]));
