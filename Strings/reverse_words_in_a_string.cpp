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
	    //initialize the variables
       string ans;
        int i=0;
       
        while(i<s.length()){ //use the pointer to traverse the string
           while(i<s.length() && s[i] == ' ') i++;
            if(i>=s.length()) break; // if pointer exceeds the length of the string break!
            int j=i+1; // initialize another pointer just ahead of i
            while(j<s.length() && s[j] != ' ') j++;
            string sub=s.substr(i,j-i); //find the individual substrings
            if(ans.length() == 0) ans=sub;
            else ans=sub + " " + ans; // concatenate the substrings in reverse
            i=j+1;
        }
        return ans;
    }
};
