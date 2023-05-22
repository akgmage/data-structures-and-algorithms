/*
Expalination:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        // Answer vector
        vector<vector<int>> result(k);
        // Max heap storage initialization
        priority_queue<vector<int>> maxHeap;
        // Construction of max heap
        for (auto& p : points) {
            int x = p[0], y = p[1];
            maxHeap.push({x * x + y * y, x, y});
            if (maxHeap.size() > k) {
                maxHeap.pop();
            }
        }
        
        for (int i = k - 1; i >= 0; --i) {
            vector<int> top = maxHeap.top();
            maxHeap.pop();
            result[i] = {top[1], top[2]};
        }
        
        return result;
    }
};

int main() {
    vector<vector<int>> points = {{1, 3}, {-2, 2}, {5, -1}, {0, 0}, {3, 4}};
    int k = 3;
    
    Solution solution;
    vector<vector<int>> closestPoints = solution.kClosest(points, k);
    
    cout << "The " << k << " closest points to the origin are:\n";
    for (const auto& point : closestPoints) {
        cout << "(" << point[0] << ", " << point[1] << ")\n";
    }
    
    return 0;
}
