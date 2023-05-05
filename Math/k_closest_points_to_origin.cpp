/*
	Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
	You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

	Input: points = [[1,3],[-2,2]], k = 1
	Output: [[-2,2]]

	Input: points = [[3,3],[5,-1],[-2,4]], k = 2
	Output: [[3,3],[-2,4]]

	Constraints:
	>  1 <= k <= points.length <= 104
	>  -104 < xi, yi < 104

*/
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        // Lets define some variables we will be needing
        vector<vector<int>> ans;
        vector<pair<double,int>> sorted;
        
        // For each point in the list points lets store distance_from_origin and point index as a pair
        for(int i=0;i<points.size();i++)
        {
            double dist=sqrt((double)pow(points[i][0],2)+(double)pow(points[i][1],2));
            sorted.push_back({dist,i});
        }

        // Now, sort the list of pairs in ascending order of distance from origin
        sort(sorted.begin(),sorted.end());

        //Store the first k points by extracting index from list of pairs into ans
        int ind=0;
        while(k--)
        {
            int pInd=sorted[ind].second;
            ans.push_back(points[pInd]);
            ind++;
        }

        // Return the final list of points ans
        return ans;
    }
};