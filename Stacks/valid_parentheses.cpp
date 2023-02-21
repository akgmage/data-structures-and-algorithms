/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 
Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

class Solution {
public:
    bool Are_pair(char opening, char closing){
        if (opening == '(' && closing == ')') return true;
        else if (opening == '[' && closing == ']') return true;
        else if (opening == '{' && closing == '}') return true;
        return false;
    }
    bool isValid(string s) {
        stack<char> Sta;
        int len = s.size();
        for(int i = 0; i < len; i++){
            if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
                Sta.push(s[i]);
            }
            else if(s[i] == ')' || s[i] == ']' || s[i] == '}'){
                if(Sta.empty() || !Are_pair(Sta.top(), s[i]))
                    return false;
                else
                    Sta.pop();
            }
        }
        return Sta.empty() ? true : false;
    }
};