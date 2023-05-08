import com.google.common.base.Stopwatch;

public class CountOddNumbersInAnInterval {
    public static void main(String[] args) {
        Stopwatch timer = Stopwatch.createStarted();
        int low = 278382788, high = 378382788;

        int res = solve(low, high);
        System.out.println(res);
        System.out.println("RunTime" + timer.stop());

    }
    public static int solve(int low, int high) {
         // O(1) time | O(1) space
        int res = 0;

        /**
         * Let's start with an odd integer, say x; what would be the next odd integer? It would be x + 2;
         * as explained above, there is exactly one even integer between every two odd integers,
         * and hence all odd integers are equally spaced with a gap of one integer. By trying out
         * some examples, we can deduce that the count of odd integers between x and a greater integer y
         * where x is odd would be ( (y - x) / 2 )+ 1
         *
         * Eg: x = 1, y = 3, then by Formula Ans: 2;
         */

        // if low is even, make it odd
        if ( (low & 1) == 0) low++;

        // low could become greater than high due to incrementation
        // if it is, the res is 0; otherwise, use the formula

        return low > high ? 0 : (high - low) / 2 + 1;


        // O(high−low) time
//        if (low % 2 == 0 ) low = low + 1;
//        while (low <= high) {
//            if (low % 2 == 1) {
//                res++;
//                System.out.println(low);
//            }
//            low += 2;
//        }
//        return res;
    }
}
