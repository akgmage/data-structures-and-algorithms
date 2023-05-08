/**
 * Problem Description
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the vector A
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the question
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [0, 1, 0, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 *
 * No water is trapped.
 */
package InterviewProblems;

public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] array = {2,1,3,2,1,2,4,3,2,1,3,1};

        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] rainWater) {
        int trapped = 0;
        int[] leftMax = new int[rainWater.length];
        int prevMax = rainWater[0];

        for (int i = 0; i < leftMax.length; i++) {
            leftMax[i] = Math.max(prevMax, rainWater[i]);
            prevMax = leftMax[i];
        }

        int[] rightMax = new int[rainWater.length];

        prevMax = rainWater[rainWater.length - 1];

        for (int i = rainWater.length - 1; i > -1; i--) {
            rightMax[i] = Math.max(prevMax, rainWater[i]);
            prevMax = rightMax[i];
        }

        for (int i = 0; i < rainWater.length; i++) {
            trapped += Math.min(leftMax[i], rightMax[i]) - rainWater[i];
        }
        return trapped;
    }
}
