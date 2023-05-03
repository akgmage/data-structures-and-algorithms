/* Question : Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
      
        //Checking if the number is equal to its reverse, if true, it is a palindrome
        return x == rev(x);
    }
  
  
    // Function to find reverse of a number
  
    public int reverse(int n){
        int reverse = 0;
        while(n != 0){
            int digit = n % 10;
            rev = digit + reverse * 10;
            n /= 10;
        }
        
        return reverse;
    }
}
 
