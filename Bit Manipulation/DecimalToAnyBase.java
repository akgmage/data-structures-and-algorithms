/**
 * Problem Description
 * Given a decimal number A and base B.
 * You are required to change the decimal number A into the corresponding value in base B and return that.
 *
 * Problem Constraints
 * 0 <= A <= 512
 * 2 <= B <= 10
 *
 *
 * Input Format
 * The first argument will be decimal number A.
 * The second argument will be base B.
 *
 *
 * Output Format
 * Return the conversion of A in base B.
 *
 *
 * Example Input
 * Input:
 * A = 4
 * B = 3
 *
 *
 * Example Output
 * Output:
 * 11
 *
 *
 * Example Explanation
 * Explanation:
 * Decimal number 4 in base 3 is 11.
 */
package BitManipulation;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        int num = 4;
        int base = 3;
        int ans = solve(num, base);
        System.out.println(ans);
    }
    public static int solve(int num, int base) {
        int ans = 0, pow = 1, currentNum = num;
        while(currentNum > 0){
            int currentDigit = currentNum % base;
            ans += currentDigit * pow;
            pow *= 10;
            currentNum /= base;
        }
        return ans;
    }
}


