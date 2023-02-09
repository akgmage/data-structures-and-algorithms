/**
 * Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
 *
 * Concatenate the string with itself.
 * Delete all the uppercase letters.
 * Replace each vowel with '#'.
 * You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
 *
 * NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
 *
 *
 *
 * Problem Constraints
 *
 * 1<=N<=100000
 *
 *
 * Input Format
 *
 * First argument is a string A of size N.
 *
 *
 *
 * Output Format
 *
 * Return the resultant string.
 *
 *
 *
 * Example Input
 *
 * A="AbcaZeoB"
 *
 *
 *
 * Example Output
 *
 * "bc###bc###"
 *
 *
 *
 * Example Explanation
 *
 * First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
 * Delete all the uppercase letters so string A becomes "bcaeobcaeo".
 * Now replace vowel with '#'.
 * A becomes "bc###bc###".
 */
package Strings;

public class StringOperations {
    public static void main(String[] args) {
        String string = "AbcaZeoB";

        String res = solve(string);
        System.out.println(res);
    }
    public static String solve(String string) {
        // O(N) time | O(N) space - where N is the length of string
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (currentChar >= 'a' && currentChar <= 'z') {
                if (currentChar == 'a' ||
                        currentChar == 'e' ||
                        currentChar == 'i' ||
                        currentChar == 'o' ||
                        currentChar == 'u'
                ) stringBuilder.append('#');
                else stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString().concat(stringBuilder.toString());
    }
}
