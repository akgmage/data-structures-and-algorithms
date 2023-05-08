/**
 *Given an integer A. Unset B bits from the right of A in binary.
 * For eg:-
 * A = 93, B = 4
 * A in binary = 1011101
 * A should become = 1010000 = 80. Therefore return 80.
 *
 *
 * Problem Constraints
 * 1 <= A <= 1018
 * 1 <= B <= 60
 *
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is a single integer B.
 *
 *
 * Output Format
 * Return the number with B unset bits from the right.
 *
 *
 * Example Input
 * Input 1:-
 * A = 25
 * B = 3
 * Input 2:-
 * A = 37
 * B = 3
 *
 *
 * Example Output
 * Output 1:-
 * 24
 * Output 2:-
 * 32
 *
 *
 * Example Explanation
 * Explanation 1:-
 * A = 11001 to 11000
 * Explantio 2:-
 * A = 100101 to 100000
 */

package BitManipulation;

public class UnsetXBitsFromRight {
    public static void main(String[] args) {
        long a = 25; int b = 3;
        long res = solve(a, b);
        System.out.println(res);
    }
    public static long solve(long a, int b) {

        // O(1) time | O(1) space
        long MAX_VALUE = Long.MAX_VALUE;
        return a & (MAX_VALUE << b);

        // O(N) time | O(1) space
//        for (int i = 0; i < b; i++) {
//            if ( ((a << i) & 1) == 1) // if bit is 1, then toggle bit.
//                a = a ^ (1L << i);
//        }
//        return a;
    }
}
