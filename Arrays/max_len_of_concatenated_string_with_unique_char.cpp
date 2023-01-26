/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.

*/

class Solution {
public:
    int check(vector<string>& arr, int i, string s){
        if(i == arr.size()){
            int freq[26] = {0};
            for(int k = 0; k < s.length(); k++){
                if(freq[s[k]-'a'] == 1)
                    return 0;
                freq[s[k]-'a']++;                
            }
            return s.length();
        }
        int op1, op2;
        op1 = op2 = INT_MIN;
        // include the string
        if(s.length() + arr[i].length() <= 26){
            op1 = check(arr, i+1, s + arr[i]);
        }    
        // exclude it
        op2 = check(arr, i+1, s);
        return max(op1, op2);
    }
    int maxLength(vector<string>& arr) {
        return check(arr, 0, "");
    }
};