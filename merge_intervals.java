/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]. */







int len = intervals.length;  // Get the length of the input intervals array
int i = 0;  // Initialize a variable to keep track of the current interval being merged
List<int[]> result = new ArrayList<>();  // Create an empty ArrayList to store the merged intervals
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));  // Sort the intervals based on their start times using a lambda expression
int first = intervals[i][0];  // Initialize the start time of the first merged interval to be the start time of the first interval in the sorted list
int second = intervals[i][1];  // Initialize the end time of the first merged interval to be the end time of the first interval in the sorted list

while (i < len) {  // Iterate through the intervals until all have been merged
    if (intervals[i][0] <= second) {  // If the start time of the current interval is less than or equal to the end time of the current merged interval, they overlap
        second = Math.max(second, intervals[i][1]);  // Update the end time of the current merged interval to be the maximum of the two end times
    } else {  // If the current interval does not overlap with the current merged interval
        result.add(new int[]{first, second});  // Add the current merged interval to the output list
        first = intervals[i][0];  // Update the start time of the current merged interval to be the start time of the current interval
        second = intervals[i][1];  // Update the end time of the current merged interval to be the end time of the current interval
    }
    i++;  // Move on to the next interval
}
result.add(new int[]{first, second});  // Add the last merged interval to the output list
return result.toArray(new int[0][]);  // Convert the output ArrayList to an array and return it

