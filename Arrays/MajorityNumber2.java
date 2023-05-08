/**
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * The only argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * [1 2 3 1 1]
 *
 *
 * Example Output
 * 1
 *
 *
 * Example Explanation
 * 1 occurs 3 times which is more than 5/3 times.
 */


package InterviewProblems;

public class MajorityNumber2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1};
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] nums) {
        // O(N) time | O(1) space
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, len = nums.length;

        for (int num : nums) {
            if (num == num1) count1++;
            else if(num == num2) count2++;
            else if(count1 == 0) {
                num1 = num;
                count1++;
            }
            else if(count2 == 0 ) {
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            if (num == num2) count2++;
        }
        if (count1 > len / 3) return num1;
        else  if (count2 > len / 3) return num2;
        else  return -1;
    }
}
