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
        vector<vector<int>>v;
        sort(intervals.begin(), intervals.end());
        vector<int>v1=intervals[0];
        for(int i=1; i<intervals.size(); i++){
            if(v1[1]<intervals[i][0]){
                v.push_back(v1);
                v1=intervals[i];
            }
            else{
                v1[1]=max(v1[1], intervals[i][1]);
            }
        }
        v.push_back(v1);
        return v;
    }
};
