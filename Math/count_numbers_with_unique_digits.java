/* Implement countNumbersWithUniqueDigits(n), which calculates the number of 
all numbers with unique digits, x, where 0 <= x < 10^n.

Explanation:
- For n=0, the answer is 1 (only the number 0, here considered to have 0 digits).
- For n=1, the answer is the number of one-digit numbers with unique digits (9), 
  plus the result for n=0 (1).
- For n=2, the answer is the number of two-digit numbers with unique digits (between 
  10 and 99), plus the result for n=1. The number of two-digit numbers with unique digits 
  is 9*9 (9 possible first digits between 1-9, then 9 possible second digits between 0-9 
  that are different from the first digit).
- For n=3, the answer is the number of three-digit number with unique digits (between 100 
  and 999), plus the result for n=2. The number of three-digit numbers with unique digits 
  is 9*9*8 (9 possible first digits between 1-9, then 9 possible second digits between 0-9 
  that are different from the first digit, then 8 possible third digits between 0-9 that are 
  different from the first two).
- And so on, using recursive calls of the same function.
Note: There are no numbers with 11 or more digits that have unique digits. So for n>=10, the
result will be the same for any n.

Example 1:
Input: n=3
Output: 739

Example 2:
Input: n=6
Output: 168571

Example 3:
Input: n=8
Output: 2345851

Constraints:
n >= 0

Time complexity: O(n)
Space complexity: O(n)

*/

class Solution {

    public int countNumbersWithUniqueDigits(int n) {

        if (n==0) {
            return 1;
        }

        int counter = 9;
        for (int i=1; i<n; i++) {
            counter *= (10-i);
        }

        return counter+countNumbersWithUniqueDigits(n-1);

    }

}
