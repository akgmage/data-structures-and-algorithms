/**
 *  Given an integer N , write program to count number of digits in N.
 *
 *
 * Example 1:
 * Input: N = 12345
 * Output: 5
 * Explanation: N has 5 digits
 */
public class CountDigits {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(evenlyDivides(n));
    }
    public static int evenlyDivides(int n) {
        // O(log(N)) time | O(1) space
        return (int) Math.ceil(Math.log10(n));
//        int result = 0;
//        int num = n; // 23
//        while(num > 0) {
//            result += 1;
//            num /= 10;
//        }
//        return result;
    }
}
