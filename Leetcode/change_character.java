/**
 * You are given a string A of size N consisting of lowercase alphabets.
 *
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 *
 * Find the minimum number of distinct characters in the resulting string.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * 0 <= B < N
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 *
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum number of distinct characters in the string.
 *
 *
 *
 * Example Input
 * A = "abcabbccd"
 * B = 3
 *
 *
 *
 * Example Output
 * 2
 *
 *
 *
 * Example Explanation
 * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 * So the minimum number of distinct character will be 2.
 */

package Strings;

import java.util.ArrayList;
import java.util.Collections;

public class ChangeCharacter {
    public static void main(String[] args) {
        String string = "abcabbccd";
        int b = 3;

        int res = solve(string, b);
        System.out.println(res);
    }
    public static int solve(String string, int b) {

        //count chars
        int[] charsCount = new int[26];
        for (int i = 0; i < string.length(); i++)
            ++charsCount[string.charAt(i) - 'a'];

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (charsCount[i] > 0) arrayList.add(charsCount[i]);
        }

        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); ++i) {
            b -= arrayList.get(i);
            if (b < 0) return arrayList.size() - i;
        }
        return 1;
    }
}
