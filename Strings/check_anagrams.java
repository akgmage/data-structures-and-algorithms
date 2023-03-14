/**
 * You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
 *
 * Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * A and B are lowercase strings
 *
 *
 * Input Format
 * Both arguments A and B are a string.
 *
 *
 * Output Format
 * Return 1 if they are anagrams and 0 if not
 *
 *
 * Example Input
 * Input 1:
 * A = "cat"
 * B = "bat"
 * Input 2:
 * A = "secure"
 * B = "rescue"
 *
 *
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 1
 *
 *
 * Example Explanation
 * For Input 1:
 * The words cannot be rearranged to form the same word. So, they are not anagrams.
 * For Input 2:
 * They are an anagram.
 */
package Strings;

public class CheckAnagrams {
    public static void main(String[] args) {
        String string1 = "secure";
        String string2 = "rescue";

        int res = solve(string1, string2);
        System.out.println(res);
    }

    public static int solve(String string1, String string2) {

        // O(N) time | O(1) space

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        // build freq array and store count for each letter
        for (int i = 0; i < string1.length(); i++) {
            freq1[string1.charAt(i) - 'a']++;
            freq2[string2.charAt(i) - 'a']++;
        }
        // compare if count of each letter 
        // if mismatch occurs then return 0
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return 0;
        }

        return 1;

//        char[] char1 = string1.toCharArray();
//        Arrays.sort(char1);
//
//        char[] char2 = string2.toCharArray();
//        Arrays.sort(char2);
//
//        String str1 = new String(char1);
//        String str2 = new String(char2);
//
//        if (str1.equals(str2)) return 1;
//        return 0;
    }
}
