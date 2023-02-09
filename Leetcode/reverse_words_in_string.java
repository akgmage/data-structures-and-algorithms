/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 */

package Strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String string = "the sky is blue";

        String res = solve(string);
        System.out.println(res);
    }
    public static String solve(String string) {
        // O(N) time | O(N) - where N is the length of the array.

        //Convert String to String Builder
        //and trim spaces at the same time
        StringBuilder stringBuilder = trimSpaces(string);

        System.out.println(string);

        //reverse the whole word
        reverse(stringBuilder, 0, stringBuilder.length() - 1);
        System.out.println(stringBuilder);

        //reverse each word
        reverseEachWord(stringBuilder);
        System.out.println(stringBuilder);

        return stringBuilder.toString();
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

