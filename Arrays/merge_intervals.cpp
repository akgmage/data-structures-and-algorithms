/* Array: Merge intervals in C++ #1113
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/


class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>>v;  // Create an empty vector of vectors to store the merged intervals
        sort(intervals.begin(), intervals.end());  // Sort the intervals based on their start times
        vector<int>v1=intervals[0];  // Initialize the first merged interval to be the first interval in the sorted list
        for(int i=1; i<intervals.size(); i++){  // Iterate through the sorted intervals starting from the second interval
            if(v1[1]<intervals[i][0]){  
            // If the end time of the current merged interval is less than the start time of the next interval, then they don't overlap
                v.push_back(v1);  // Add the current merged interval to the output vector
                v1=intervals[i];  // Update the current merged interval to be the next interval
            }
            else{  // If the current merged interval and the next interval overlap
                v1[1]=max(v1[1], intervals[i][1]);  // Update the end time of the current merged interval to be the maximum of the two end times
            }
        }
        v.push_back(v1);  // Add the last merged interval to the output vector
        return v;  // Return the vector of merged intervals
    }
};

// TIME COMPLEXITY : O(n log n)
// SPACE COMPLEXITY : O(n)
