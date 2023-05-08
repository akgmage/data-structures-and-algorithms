/**
 * Problem Description
 * Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
 * Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
 *
 * Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.
 *
 *
 * Problem Constraints
 * 0 <= A <= 10^9
 *
 *
 * Input Format
 * The only argument given is an integer A.
 *
 *
 * Output Format
 * Return the minimum number of times help taken from Sam.
 *
 *
 * Example Input
 * Input 1:
 * A = 5
 * Input 2:
 *
 * A = 3
 *
 *
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 * Initial score : 0
 * Takes help from Sam, score : 1
 * Alex solves a question, score : 2
 * Alex solves a question, score : 4
 * Takes help from Sam, score: 5
 * Explanation 2:
 *
 * Initial score : 0
 * Takes help from Sam, score : 1
 * Alex solves a question, score : 2
 * Takes help from Sam, score : 3
 */

package BitManipulation;

public class HelpFromSam {
    public static void main(String[] args) {
        int a = 5;
        int res = solve(a);
        System.out.println(res);
    }
    public static int solve(int a) {
        // O(N) time | O(1) space
        // count 1 bits
        int res = 0, currentNum = a;

        while (currentNum != 0) {
            if ((currentNum & 1) == 1) res++;
            currentNum = currentNum >> 1;
        }
        return res;
    }

}
