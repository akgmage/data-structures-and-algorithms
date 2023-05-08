/**
 * Given N boards with length od each board,
 * a. A painter takes T unit of time to paint 1 unit of length.
 * b. A board can only be painted by 1 painter
 * c. A painter can only paint boards placed next to each
 * other (i.e continuous segment)
 *
 * Find the Min.no.of painters required to paint all boards
 * in X units of time. return -1 if not possible.
 */
package Searching;

public class PaintersPartitionBasic {
    public static void main(String[] args) {
        int n = 5;
        int t = 2;
        int x = 15;
        int[] boards = {5, 3, 6, 1, 4};

        int ans = solve(n, t, x, boards);
        System.out.println(ans);
    }
    public static int solve(int n, int t, int x, int[] boards) {

        int count = 1; // initially take 1 painter
        int timeleft = x;

        for (int i = 0; i < n; i++) {
            if (boards[i]*t > x) {
                return -1;
            }
            if (boards[i]*t <= timeleft) {
                timeleft -= boards[i]*t;
            } else {
                count++;
                timeleft = x - boards[i]*t;
            }
        }
        return count;
    }
}
