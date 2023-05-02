/*
	Given an input string s, reverse the order of the words.
	A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
	Return a string of the words in reverse order concatenated by a single space.

	[Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.]
	

	Input: s = "the sky is blue"
	Output: "blue is sky the"

	Input: s = "  hello world  "
	Output: "world hello"

	Input: s = "a good   example"
	Output: "example good a"
	
	Constraints:

	> 1 <= s.length <= 104
	> s contains English letters (upper-case and lower-case), digits, and spaces ' '.
	> There is at least one word in s.
 
*/
class Solution {
public:
    string reverseWords(string s) {
        // Intitalize variables we will be needing
       stack<string> st;
        string ans;
        string curr_word="";

        // Traverse through the string and push each word into the stack seperated by ' '.
        for(int i=0;i<s.length();i++)
        {
            if(s[i]==' '){
                if(curr_word!="") st.push(curr_word);
                curr_word="";
            }
            else{
                curr_word+=s[i];
            }
        }
        
        // Push the last word in stack as string may not end with ' '.
        if(curr_word!="") st.push(curr_word);
        
        //Pop stored words from stack and add them to the ans string seperated by " " except for the last word.
        while(!st.empty())
        {
            ans+=st.top();
            st.pop();
            if(!st.empty()) ans = ans+" ";
           
        }

        // Return the ans string
        return ans;  
    }
};