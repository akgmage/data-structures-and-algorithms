/**
  Time Complexity: O(n), Space Complexity: O(1)
    
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

    int v[128] = {0};

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

        if(!sz)
            return 0;
        int mx = 0;
        while (a <= b && b < sz)
        {

            v[s[b++] - ' ']++;
            int curMax = mxDistinct();
            if(curMax)
                mx = max(mx, curMax);
            else
                v[s[a++] - ' ']--;
        }

        return mx;
    }
};
