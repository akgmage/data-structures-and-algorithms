/* Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-2^31 <= x <= 2^31  - 1
*/ 
// function for reversing the integer;

  int reverse(int x) {
        int ans =0;
        if(x > INT_MAX || x < INT_MIN) // checking the integer is in range of -2^31 <= x <= 2^31  - 1
           return 0;  
        while(x != 0){
        if(ans > INT_MAX/10 || ans < INT_MIN/10) // -2^31 <= x <= 2^31  - 1 this condition for border values of range
           return  0;
            ans =  ans*10; // we increaing the unit position each itereation
            ans += x%10;   // here we finding the last unit elemet so that we can add in ans
            x /=10;   // decreamenting the value or we can say elemenating the last unit element that we are find

        }
        return ans;  // returning the ans;
    }
