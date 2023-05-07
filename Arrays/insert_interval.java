/* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]] */

public int[][] insert(int[][] intervals, int[] newInterval) {  // Define a method that takes in an array of intervals and a new interval to be inserted
    List<int[]> list =  new ArrayList<>();  // Create a new ArrayList to store the merged intervals
    for(int[] curr : intervals){  // Iterate through each interval in the input array
        if(curr[0] > newInterval[1]){  // If the start time of the current interval is greater than the end time of the new interval, they do not overlap
            list.add(newInterval);  // Add the new interval to the output list
            newInterval = curr;  // Update the new interval to be the current interval
        }
        else if(curr[1] < newInterval[0]){  // If the end time of the current interval is less than the start time of the new interval, they do not overlap
            list.add(curr);  // Add the current interval to the output list
        }else{  // If the intervals overlap
            int start = Math.min(curr[0], newInterval[0]);  // Merge the start times of the intervals
            int end = Math.max(curr[1], newInterval[1]);  // Merge the end times of the intervals
            newInterval[0] = start;  // Update the start time of the new interval to be the merged start time
            newInterval[1] = end;  // Update the end time of the new interval to be the merged end time
        }
    }
    list.add(newInterval);  // Add the last merged interval to the output list
    int[][] answer = new int[list.size()][];  // Create a new 2D array to store the merged intervals
    for(int i=0;i<list.size();i++){  // Convert the ArrayList to a 2D array
        answer[i] = list.get(i);
    }
    return answer;  // Return the merged intervals as a 2D array
}

