/**
 * You are given a number A. You are also given a base B. A is a number on base B.
 * You are required to convert the number A into its corresponding value in decimal number system.
 *
 *
 * Problem Constraints
 * 0 <= A <= 109
 * 2 <= B <= 9
 *
 *
 * Input Format
 * First argument A is an integer.
 * Second argument B is an integer.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 * A = 1010
 * B = 2
 * Input 2:
 * A = 22
 * B = 3
 *
 *
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 8
 *
 *
 * Example Explanation
 * For Input 1:
 * The decimal 10 in base 2 is 1010.
 * For Input 2:
 * The decimal 8 in base 3 is 22.
 */
package BitManipulation;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        int num = 22;
        int base = 3;
        int ans = solve(num, base);
        System.out.println(ans);
    }
    public static int solve(int num, int base) {
        // O(1) time | O(1) space
        int res = 0, power = 1, currentNum = num;
        while (currentNum != 0) {
            int currentDigit = currentNum % 10;
            res += currentDigit * power;
            power *= base;
            currentNum /= 10;
        }

        return res;
    }
}