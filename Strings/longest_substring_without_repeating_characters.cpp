/**
  Time Complexity: t(n) = n * 128 -> O(n).
  Where n is the size of string s.

  Space Complexity: O(1)

  Given a string s, find the length of the longest substring without repeating characters.

  Example 1:
  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.

  Example 2:
  Input: s = "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.

  Example 3:
  Input: s = "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3.
  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

  Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

**/


class Solution {
public:



    // Array to store the frequency of characters for sub-string that's starts at index a and end at index b - 1.
    int v[128] = {0};

    /**
        Function: mxDistinct returns the maximum number of unique charachters of substring s[a, b[
        if there is at least one character that present more than one time the function returns 0,
        beacause where are looking for the lonest substring withput repating characters.
    **/
    int mxDistinct()
    {
        int c = 0;
        for (int i = 0; i < 128; ++i) {
            if(v[i] > 1)
                return 0;

            if(v[i] == 1)
                c++;
        }
        return c;
    }

    int lengthOfLongestSubstring(string s) {

        int a = 0, b = 0;
        int sz = s.size();

        if(!sz) // If the string s is empty the functon returns 0.
            return 0;

        int mx = 0; // Variable mx to store the result.

        while (a <= b && b < sz) 
        {

            v[s[b++] - ' ']++; // Count how many times character at index b (s[b]) appears in the string s.

            int curMax = mxDistinct(); // Variable to store the current max or the max so far.
	    if(curMax) /**
                           If we find a substring without repeating characters we take the maximum between mx and curMax.
	                    REMEMBER: We are looking for the longest one. Actullay, the size of the longest one.
	               **/

                mx = max(mx, curMax);
            else // If there is no such a substring we start looking for substring that begins at index a + 1.
                v[s[a++] - ' ']--;
        }

        return mx;
    }
};
