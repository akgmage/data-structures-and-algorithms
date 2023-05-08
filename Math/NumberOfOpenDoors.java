import java.util.Arrays;

/**
 * Problem Description
 * Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.
 *
 * A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.
 *
 * In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
 * In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
 * In the third go, he/she alters the states of doors numbered 3, 6, 9 …
 * This continues till the A'th go in, which you alter the state of the door numbered A.
 *
 * Find and return the number of open doors at the end of the procedure.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 * Return the number of open doors at the end of the procedure.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 * Input 2:
 *
 *  A = 6
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Input 1:
 *
 *  In the first go, he/she alters the states of doors numbered 1, 2, 3, 4, 5. Now, all doors are open.
 *  In the second go, he/she closes the doors numbered 2, 4.
 *  In the third go, he/she closes the door numbered 3.
 *  In the fourth go, he/she open the door numbered 4.
 *  In the fifth go, he/she closes the door numbered 5.
 *  Doors opened at the end are 1 and 4.
 * Input 2:
 *
 *  In the first go, he/she alters the states of doors numbered 1, 2, 3, 4, 5, 6. Now, all doors are open.
 *  In the second go, he/she closes the doors numbered 2, 4, 6.
 *  In the third go, he/she closes the door numbered 3 and opens door 6.
 *  In the fourth go, he/she open the door numbered 4.
 *  In the fifth go, he/she closes the door numbered 5.
 *  In the sixth go, he/she closes the door numbered 6.
 *  Doors opened at the end are 1 and 4.
 */
public class NumberOfOpenDoors {
    public static void main(String[] args) {
        int n = 6;
        int ans = solve(n);
        System.out.println(ans);
    }
    public static int solve(int n ) {

        // find spf
        int[] spf = getSpf(n);
        System.out.println(Arrays.toString(spf));
        return  1;
    }
    public static int[] getSpf(int n) {
        int[] spf = new int[n + 1];

        for (int i = 2; i < spf.length; i++) {
            spf[i] = i;
        }

        for (int i = 2; i*i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i*i; j <= n; j+=i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;

    }
}
