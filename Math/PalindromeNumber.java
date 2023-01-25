// https://leetcode.com/problems/palindrome-number
public class PalindromeNumber {
    /**
     * O(log(N)) time base 10.  We divided the input by 10 for every iteration
     *
     * O(1) space
     */
    public static void main(String[] args) {
        int x = 123;
        System.out.println(solve(x));
    }
    public static Boolean solve(int x) {
        int tmp = x, cache = 0;
        while(tmp > 0) {
            cache = cache * 10 + tmp % 10;
            tmp /= 10;
        }
        return  x > 0 && cache == x;
    }
}
