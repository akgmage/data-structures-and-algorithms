/*
    You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
    You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
    For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
    Return an array answer, where answer[j] is the answer to the jth query.

    Example 1:
    Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
    Output: [3,2,2]
    Explanation: 
    queries[0] is the first circle [2,3,1], which include the points [1,3], [2,2] and [3,3].
    queries[1] is the second circle [4,3,1], which include the points [3,3] and [5,3].
    and queries[2] is the third circle [1,1,2], which include the point [1,3] and [2,2].


    Example 2:
    Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
    Output: [2,3,2,4]
    Explanation: 
    queries[0] is the first circle [1,2,2], which include the points [1,1] and [2,2].
    queries[1] is the second circle [2,2,2], which include the points [1,1], [2,2] and [3,3].
    queries[2] is the third circle [4,3,2], which include the points [3,3] and [4,4].
    and queries[3] is the fourth circle [4,3,3], which include the points [2,2], [3,3], [4,4] and [5,5].

    Explanation of the approach:
    1. We will use the formula of distance between two points to find the distance between the center of the circle and the given point.
    2. If the distance is less than or equal to the radius of the circle, then the point lies inside the circle.

    Time Complexity: O(N * Q), where N is the number of points and Q is the number of queries.
    Space Complexity: O(1)
*/

class Solution
{
public:
    vector<int> countPoints(vector<vector<int>> &points, vector<vector<int>> &queries)
    {
        vector<int> ans;
        // Iterating over the queries.
        for (int i = 0; i < queries.size(); i++)
        {
            // Initializing the count to 0. This will store the number of points inside the circle.
            int count = 0;
            // Iterating over the points.
            for (int j = 0; j < points.size(); j++)
            {
                // Calculating the distance between the center of the circle and the given point.
                int distance = pow(points[j][0] - queries[i][0], 2) + pow(points[j][1] - queries[i][1], 2);
                // If the distance is less than or equal to the radius of the circle, then the point lies inside the circle.
                if (distance <= pow(queries[i][2], 2))
                    count++; // If the point lies inside the circle, then increment the count.
            }
            // Pushing the count to the answer vector.
            ans.push_back(count);
        }
        return ans;
    }

    // Further reading: https://www.geeksforgeeks.org/queries-points-number-points-lie-given-circle/
};