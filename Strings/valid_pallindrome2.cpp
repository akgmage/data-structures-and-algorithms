// Check whether a string can be a valid palindrome by removing at most one character from it
/*
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    Constraints: string.length The string only consists of English letters

    Sample Input : "madame"
    Output : True

    Sample Input : "masdasd"
    Output : False	
*/
class Solution {
public:
    bool validate(string s, int start, int end){
        int len = s.size();
        while(start < end){
            if(s[start] == s[end]){
                start++;
                end--;
            }
            // doesn't match then return false
            else{
                return false;
            }
        }
        return true;
    }
    bool validPalindrome(string s) {
        int len = s.size();
        // initialize two pointers at opposite end of string
        int start = 0, end = len - 1;
        while(start < end){
            // if value at left and right index match then move them closer
            if(s[start] == s[end]){
                start++;
                end--;
            }
            else{ // if mismatch occurs then skip one and check rest
                bool r1 = validate(s, start + 1, end); // skip one from left and check remaining
                bool r2 = validate(s, start, end -1); // skip one from right and check remaining
                return r1 || r2; // if either is true return true
            }   
        }
        return true; 
    }
};