/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Count Numbers with Unique Digits in C++
Issue Number : #500
Problem statement : 

Explanation of the below C++ code :

In this implementation, we first handle the base case of n = 0 by returning 1. Then, we initialize the answer ans to 10 since there are 10 unique digits between 0 and 9. We also initialize the variables unique_digits and available_digits to 9 since we can't use 0 as the first digit.

Next, we enter a loop that runs n-1 times (since we have already considered the case of i = 1). In each iteration of the loop, we compute unique_digits as the product of the current value of unique_digits and available_digits. We then add unique_digits to the answer ans and decrement available_digits. This is because we can't use the digits that have already been used for the previous digits.

Finally, we return the value of ans.

The time complexity of this algorithm is O(n), where n is the input parameter representing the number of digits.

The space complexity of this algorithm is O(1), as we are only using a constant amount of extra memory to store the variables ans, unique_digits, and available_digits, regardless of the input size.

*/
-------------------------------------------------------------------------//C++ code begins here----------------------------------------------------------------------------

class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;   // return 1 for n = 0
        }
        int ans = 10;   // start with 10 unique digits, as we can have numbers 0-9
        int unique_digits = 9;  // start with 9 digits, as we cannot use 0 as first digit
        int available_digits = 9;   // remaining available digits
        while (n-- > 1 && available_digits > 0) {
            unique_digits *= available_digits; // calculate number of unique numbers that can be formed
            ans += unique_digits; // add number of unique numbers to the answer
            available_digits--; // reduce available digits by 1
        }
        return ans; // return final answer
    }
};
