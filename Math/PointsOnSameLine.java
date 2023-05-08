/**
 * Problem Description
 * Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
 *
 * Find and return the maximum number of points that lie on the same line.
 *
 *
 *
 * Problem Constraints
 * 1 <= (length of the array A = length of array B) <= 1000
 *
 * -105 <= A[i], B[i] <= 105
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer array B.
 *
 *
 *
 * Output Format
 * Return the maximum number of points which lie on the same line.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [-1, 0, 1, 2, 3, 3]
 *  B = [1, 0, 1, 2, 3, 4]
 * Input 2:
 *
 *  A = [3, 1, 4, 5, 7, -9, -8, 6]
 *  B = [4, -8, -3, -2, -1, 5, 7, -4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
 * Explanation 2:
 *
 *  Any 2 points lie on a same line.
 */
package BasicMaths;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnSameLine {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, 3, 4};
        int[] b = {1, 0, 1, 2, 3, 4};

        int ans = solve(a, b);
        System.out.println(ans);
    }
    public static int solve(int[] x, int [] y) {
        int n = x.length;
        if (n < 3) return n;

        int ans = 0;
        int curMax = 0, overLap = 0, vertical = 0;

        for (int i = 0; i < n; i++) {
            curMax = 0;
            overLap = 0;
            vertical = 0;
            HashMap<ArrayList<Integer>, Integer> mp = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                if (x[i] == x[j] && y[i] == y[j]) overLap++;
                else if (x[i] == x[j]) vertical++;
                else {
                    int xDiff = x[j] - x[i];
                    int yDiff = y[j] - y[i];
                    int z = gcd(xDiff, yDiff);
                    xDiff /= z;
                    yDiff /= z;
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(xDiff);
                    tmp.add(yDiff);
                    // mp stores the slope of the line between i-th and j-th point
                    if (mp.get(tmp) == null) {
                        mp.put(tmp, 1);
                    } else {
                        mp.put(tmp, mp.get(tmp) + 1);
                    }
                }
            }
        }
        return 0;
    }
    public static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y%x, x);
    }
}
