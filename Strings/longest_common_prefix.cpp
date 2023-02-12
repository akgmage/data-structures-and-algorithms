/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

Time complexity : O(strs)
*/

#include<bits/stdc++.h>

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0) return "";
        string ans = "";
        //  fix one string and check the common prefix of this string with other strings
        // s is the smallest string, so longest cant be greater than smallest string in array
        string s = *min_element(strs.begin(), strs.end());
        for(int i = 0; i < s.size(); i++){
            for(int j = 0; j < strs.size(); j++){
                if(s[i] != strs[j][i])
                    return ans;
            }
            ans.push_back(s[i]);
        }
        return ans;
    }
};