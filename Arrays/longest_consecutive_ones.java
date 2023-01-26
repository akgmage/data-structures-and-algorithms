/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the length of the longest consecutive 1’s that can be achieved.
 * Constraints
 *
 * 1 <= length of string <= 1000000
 * A contains only characters 0 and 1.
 * For Example
 *
 * Input 1:
 *     A = "111000"
 * Output 1:
 *     3
 *
 * Input 2:
 *     A = "111011101"
 * Output 2:
 *     7
 */

package InterviewProblems;

public class longestConsecutiveOnes {
    public static void main(String[] args) {
        String str = "11010110000000000";
        int ans = solve(str);
        System.out.println(ans);
    }
    public static int solve(String str) {
        // O(N) time | O(1) space
        int ans = 0;
        int len = str.length();
        int totalOnes = 0;

        // first count total one's
        for (int i = 0; i < len; i++) { // 1110111
            char currentChar = str.charAt(i);
            if (currentChar == '1') totalOnes++;
        }

        if (totalOnes == 0) return 0;
        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '0') {
                int leftIdx = i - 1, leftOnes = 0;
                while (leftIdx > -1 && str.charAt(leftIdx) == '1') {
                    leftIdx--;
                    leftOnes++;
                }

                int rightIdx = i + 1, rightOnes = 0;
                while (rightIdx < len && str.charAt(rightIdx) == '1') {
                    rightIdx++;
                    rightOnes++;
                }

                if (leftOnes + rightOnes == totalOnes) {
                    ans = Math.max(ans, leftOnes + rightOnes);
                } else {
                    ans = Math.max(ans, leftOnes + rightOnes + 1);
                }
            }
        }
        return ans;
    }
}
