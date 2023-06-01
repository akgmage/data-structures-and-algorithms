// Author : SUYASH SINGH
/*
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]

Explanation:

The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
*/
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<pair<double, vector<int>>> v;
        for(auto x: points) {
            double dis = sqrt(x[0] * x[0] + x[1] * x[1]);
            v.push_back({dis, {x[0], x[1]}});
        }
        sort(v.begin(), v.end());
        vector<vector<int>> ans;
        for(int i=0; i<k; i++) ans.push_back(v[i].second);
        return ans;
    }
};

int main() {
    // create a vector of points
    vector<vector<int>> points {{3, 4}, {1, 2}, {-1, -1}, {0, 0}, {2, 3}, {-2, 2}};
    int k = 3;
    Solution s;
    vector<vector<int>> closest_points = s.kClosest(points, k);
    cout << "The " << k << " closest points to the origin are:\n";
    for(auto point: closest_points) {
        cout << "(" << point[0] << ", " << point[1] << ")\n";
    }
    return 0;
}
