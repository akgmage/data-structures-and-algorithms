/*
	Problem definition:
		Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
		and return an array of the non-overlapping intervals that cover all the intervals in the input.

	Approach:
		The approach is to first sort the intervals by their start times. 
		Then we initialize a new merged intervals array and loop through all the intervals. 
		For each interval, if the merged array is empty or 
		the current interval does not overlap with the previous interval, 
		then we add the current interval to the merged array. 
		Otherwise, we merge the current interval with the previous interval 
		by updating the end time of the previous interval to the maximum of 
		its original end time and the end time of the current interval. 
		Finally, we return the merged array.

	Complexity:
		The time complexity of this solution is O(n log n) due to the initial sorting step. 
		The space complexity is O(n) to store the merged intervals array.

	Sample input/outputs:
		Example 1:
		Input: [[1,4],[4,5]]
		Output: [[1,5]]

		Example 2:
		Input: [[1,3],[2,6],[8,10],[9,12]]
		Output: [[1,6],[8,12]]

		Example 3:
		Input: [[1,4],[0,4]]
		Output: [[0,4]]
*/

function merge(intervals) {
    // Sort the intervals by their start times
    intervals.sort((a, b) => a[0] - b[0]);
  
    // Initialize a new merged intervals array
    const merged = [];
  
    // Loop through all the intervals
    for (let i = 0; i < intervals.length; i++) {
      let interval = intervals[i];
  
      // If the merged array is empty or the current interval does not overlap with the previous interval
      // then add the current interval to the merged array
      if (merged.length === 0 || interval[0] > merged[merged.length - 1][1]) {
        merged.push(interval);
      } else {
        // Otherwise, merge the current interval with the previous interval
        merged[merged.length - 1][1] = Math.max(merged[merged.length - 1][1], interval[1]);
      }
    }
  
    // Return the merged array
    return merged;
  }
  
  // Example usage:
  const intervals = [[1,3],[2,6],[8,10],[15,18]];
  console.log(merge(intervals)); // [[1,6],[8,10],[15,18]]
  