/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lowercase English letters.
*/

class Solution {
public:
  /*  class Pair{
        public:
            char first;
            int second;
            
            Pair(char f, int s){
                first = f;
                second = s;
            }        
    };
  */  
    string removeDuplicates(string s, int k) {
        stack<pair<char, int> > St;
        for(int i = 0; i < s.size(); i++){
            if(St.empty() || s[i] != St.top().first){
                St.push(make_pair(s[i], 1));
            }
            else{
                St.top().second++;
                int count = St.top().second;
                if(count == k){
                    St.pop();
                }
            }
        }
        string ans = "";
        while(!St.empty()){
            int count = St.top().second;
            while(count--){
                ans += St.top().first;
            }
            St.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};