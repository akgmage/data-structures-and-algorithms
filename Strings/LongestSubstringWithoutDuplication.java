/**Problem Description
 Given a string A, find the length of the longest substring without repeating characters.

 Note: Users are expected to solve in O(N) time complexity.



 Problem Constraints
 1 <= size(A) <= 106

 String consists of lowerCase,upperCase characters and digits are also present in the string A.



 Input Format
 Single Argument representing string A.



 Output Format
 Return an integer denoting the maximum possible length of substring without repeating characters.



 Example Input
 Input 1:

 A = "abcabcbb"
 Input 2:

 A = "AaaA"


 Example Output
 Output 1:

 3
 Output 2:

 2


 Example Explanation
 Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
 Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 *
 */
package Strings;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        String string = "abcabcbb";

        int ans = solve(string);
        System.out.println(ans);
    }
    public static int solve(String string) {
        // O(N) time | O(N) space
        int[] longest = {0, 1};

        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int startIdx = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (lastSeen.containsKey(c)) {
                startIdx = Math.max (startIdx, lastSeen.get(c) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest[0] = startIdx;
                longest[1] = i + 1;
            }
            lastSeen.put(c, i);
        }
        return longest[1] - longest[0];
    }
}
