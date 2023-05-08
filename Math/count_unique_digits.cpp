/*
	Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

	Input: n = 2
	Output: 91

	Input: n = 0
	Output: 1

	Constraints:
	> 0 <= n <= 8
*/

class Solution {
public:

/* 
        By using concepts of permutation and combination, we can count the unique  numbers for N digits.
    For the first digit we can choose any 1 digit from 1-9
    For the latter digits we can choose any 1 digit from 0-9 except the digits     already used 

*/
    int countNumbersWithUniqueDigits(int n) {
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int temp=1;
            int k=i;
            // for the latter digits we can choose any 1 digit from 0-9 except the digits already used
            for(int j=0;j<k;j++)
            {
                temp*=(9-j);
            }
            // for the first digit we can choose any 1 digit from 1-9
            ans=ans + 9*temp;
        }

        // Return the final answer
        return ans+1;
    }
};