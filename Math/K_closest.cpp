/*
 Author: SUYASH SINGH

Problem statement:-Find K Closest Elements
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
Explaination:

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
             // Calculate the squared distance from the origin using the formula x^2 + y^2
            // Store the distance along with the coordinates (x, y) in the maxHeap
            maxHeap.push({x * x + y * y, x, y});
            // If the size of the maxHeap exceeds k, remove the point with the maximum distance
            if (maxHeap.size() > k) {
                maxHeap.pop();
            }
        }
        // Extract the k closest points from the maxHeap and store them in the result vector
        for (int i = k - 1; i >= 0; --i) {
            vector<int> top = maxHeap.top();
            maxHeap.pop();
            result[i] = {top[1], top[2]};
        }
        
        // Return the result vector containing the k closest points
        
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
}/*
Time Complexity:

Constructing the maxHeap:  the overall time complexity is O(N log K).
Extracting the k closest points: O(K log K). We extract the top element from the maxHeap k times, each operation taking O(log K) time. Hence, the time complexity is O(K log K).
Therefore, the overall time complexity of the solution is O(N log K), where N is the number of points and K is the value of k.

Space Complexity:

The maxHeap stores at most k elements, so the space complexity for the maxHeap is O(K).
The result vector stores k closest points, resulting in O(K) space.
Apart from these, the solution uses a constant amount of space for variables and temporary storage.*/
