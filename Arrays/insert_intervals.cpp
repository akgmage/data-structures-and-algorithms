/* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
*/


class Solution {
public:
   vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        // get the number of intervals and initialize an index variable
        int n = intervals.size(), i = 0;
        // initialize a vector to store the result
        vector<vector<int>> res;
        
        // loop through the intervals until the end or until the end of the first interval that comes after the new interval
        while(i < n && intervals[i][1] < newInterval[0]){
            // add the current interval to the result
            res.push_back(intervals[i]);
            i++;
        }                           
        // loop through the intervals that overlap with the new interval
        while(i < n && newInterval[1] >= intervals[i][0]){
            // update the start and end of the new interval to include the current interval
            newInterval[0] = min(newInterval[0], intervals[i][0]);
            newInterval[1] = max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the new interval to the result
        res.push_back(newInterval);
        
        // add the remaining intervals to the result
        while(i < n){
            res.push_back(intervals[i]);
            i++;
        }
        // return the result
        return res;
    }
};

