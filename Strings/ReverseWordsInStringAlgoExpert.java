/**
 * Reverse Words In String
 *
 * Write a function that takes in a string of words separated by one or more whitespaces and returns a string that has these words in reverse order. For example, given the string "tim is great", your function should return "great is tim".
 *
 * For this problem, a word can contain special characters, punctuation, and numbers. The words in the string will be separated by one or more whitespaces, and the reversed string must contain the same whitespaces as the original string. For example, given the string "whitespaces    4" you would be expected to return "4    whitespaces".
 *
 * Note that you're not allowed to to use any built-in split or reverse methods/functions. However, you are allowed to use a built-in join method/function.
 *
 * Also note that the input string isn't guaranteed to always contain words.
 * Sample Input
 *
 * string = "AlgoExpert is the best!"
 *
 * Sample Output
 *
 * "best! the is AlgoExpert"
 */

package Strings;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseWordsInStringAlgoExpert {
    public static void main(String[] args) {
//        String string = "great!  is  Uday";
        String string = "the sky is blue";

        String res = solve(string);
        System.out.println(res);
    }
    public static String solve(String string) {
        // O(N) time | O(N) space where N is the length of the string
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0; // keeps track of first idx to
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);

            if (character == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(words.size() - 1) != ' ') {
                words.add(" ");
                startOfWord = idx;
            }
        }

        words.add(string.substring(startOfWord)); // last substring

        Collections.reverse(words);
        System.out.println(words);
        return String.join("", words);
    }
}
