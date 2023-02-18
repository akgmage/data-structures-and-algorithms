/* Implement lengthOfLongestSubstring(s), which calculates the length of the longest possible substring that does not contain repeating characters.

Example 1:
Input: "abcabcbaba"
Output: 3

Example 2:
Input: "dddddddd"
Output: 1

Example 3:
Input: "pwwkewo"
Output: 4

Constraints:
0 <= s.length <= 5 * 10^4

Time complexity: O(n^2)
Space complexity: O(1)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length==0) {
            return 0;
        }

        int max = 1;
        // Aiming to find substring of s that starts at index i and ends at j-1.
        int i = 0;
        int j = i+1;

        while (j<length) {
            while (j<length && (s.substring(i,j).indexOf(s.charAt(j)) == -1)) {
                j++;
            } 

            if ((j-i) > max) {
                max = j-i;
            }

            i++;
        }

        return max;
    }
}
