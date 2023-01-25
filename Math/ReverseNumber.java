// https://leetcode.com/problems/reverse-integer/
public class ReverseNumber {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(solve(x));
    }
    public static int solve(int x) {
        /**
         * pop operation:
         * pop = x % 10;
         * x /= 10;
         *
         * push operation:
         * temp = rev * 10 + pop;
         * rev = temp;
         */
        int reverse = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if(reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }
}
