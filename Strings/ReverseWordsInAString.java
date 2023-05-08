/**
 * Problem Description
 * You are given a string A of size N.
 *
 * Return the string A after reversing the string word by word.
 *
 * NOTE:
 *
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 *
 *
 * Problem Constraints
 * 1 <= N <= 3 * 105
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return the string A after reversing the string word by word.
 *
 *
 *
 * Example Input
 * Input 1:
 *     A = "the sky is blue"
 * Input 2:
 *     A = "this is ib"
 *
 *
 * Example Output
 * Output 1:
 *     "blue is sky the"
 * Output 2:
 *     "ib is this"
 *
 *
 * Example Explanation
 * Explanation 1:
 *     We reverse the string word by word so the string becomes "blue is sky the".
 * Explanation 2:
 *     We reverse the string word by word so the string becomes "ib is this".
 */

package Strings;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "   the sky is blue   ";

        String ans = solve (s);
        System.out.println(ans);
    }
    public static String solve (String s) {
        // O(N) time | O(N) - where N is the length of the array.

        //Convert String to String Builder
        //and trim spaces at the same time
//        StringBuilder stringBuilder = trimSpaces(string);

        //reverse the whole word
//        reverse(stringBuilder, 0, stringBuilder.length() - 1);

        //reverse each word
//        reverseEachWord(stringBuilder);

//        return stringBuilder.toString()

        /**
         * 1. Create a string array by removing spaces
         * 2. iterate through the string array
         *  if it is not empty string with space
         */
        String[] words = s.trim().split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i > -1; i--) {
            if (!words[i].isEmpty() && i != 0) {
                ans.append(words[i]).append(" ");
            } else ans.append(words[i]);
        }
        return ans.toString();
    }
    public static StringBuilder trimSpaces(String string) {
        int leftIdx = 0, rightIdx = string.length() - 1;

        // remove leading spaces
        while (leftIdx <= rightIdx && string.charAt(leftIdx) == ' ') ++leftIdx;

        // remove trailing spaces
        while (leftIdx <= rightIdx && string.charAt(rightIdx) == ' ') --rightIdx;

        // reduce multiple spaces to single one
        StringBuilder stringBuilder = new StringBuilder();
        while (leftIdx <= rightIdx) {
            char currentChar = string.charAt(leftIdx);

            if (currentChar != ' ') stringBuilder.append(currentChar);
            else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') stringBuilder.append(currentChar);

            ++leftIdx;
        }
        return stringBuilder;
    }

    public static void reverse(StringBuilder stringBuilder, int leftIdx, int rightIdx) {
        while (leftIdx < rightIdx) {
            char temp = stringBuilder.charAt(leftIdx);
            stringBuilder.setCharAt(leftIdx++, stringBuilder.charAt(rightIdx));
            stringBuilder.setCharAt(rightIdx--, temp);
        }
    }
    public static void reverseEachWord(StringBuilder stringBuilder) {
        int len = stringBuilder.length();
        int startIdx = 0, endIdx = 0;

        while (startIdx < len) {
            // go to the end of the word
            while (endIdx < len && stringBuilder.charAt(endIdx) != ' ') ++endIdx;
            // reverse the word
            reverse(stringBuilder, startIdx, endIdx - 1);
            // move to the next word
            startIdx = endIdx + 1;
            ++endIdx;
        }
    }
}
