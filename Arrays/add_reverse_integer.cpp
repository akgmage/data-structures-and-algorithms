/* Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
*/


class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;     // initialize two pointers, i and j to the start and end of the string respectively
        while(i<j){                 // loop until i is less than j
            if(s.charAt(i)!=s.charAt(j))   // if the characters at i and j are not equal
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);   // check if the string is a palindrome by removing either the character at i or j and return true if it is a palindrome
            j--;i++;                // update the pointers
        }
        return true;                // if the loop completes without returning false, the string is a palindrome
    }
    public static boolean isPalindrome(String ss,int i, int j){     // a helper function to check if a given substring is a palindrome
        while(i<j){
            if(ss.charAt(i)!= ss.charAt(j)) return false;  // if the characters at i and j are not equal, the substring is not a palindrome
            i++;j--;                // update the pointers
        }
        return true;                // if the loop completes without returning false, the substring is a palindrome
    }
}


/* 

APPROACH: The reverse function takes an integer as input and returns the reversed integer. The function first initializes a variable to store the reversed integer and then iterates over each digit of the input integer. In each iteration, the function extracts the rightmost digit of the input integer, checks if multiplying the reversed integer by 10 and adding the rightmost digit will cause integer overflow or underflow, adds the rightmost digit to the reversed integer, and removes the rightmost digit from the input integer. Finally, the function returns the reversed integer.

Time Complexity:
The time complexity of the reverse function is O(log(x)), where x is the input integer. This is because the function needs to iterate over each digit of the input integer, which is proportional to the logarithm of the integer.

Space Complexity:
The space complexity of the reverse function is O(1), because it only uses a constant amount of additional space to store the reversed integer and the remainder.

*/
