/* Implement countPrimes(n), which calculates the number of primes that are strictly smaller than n.

Example 1:
Input: n=0
Output: 0

Example 2:
Input: n=10
Output: 4

Example 3:
Input: n=155
Output: 36

Example 4:
Input: n=5000000
Ouput: 348513

Constraints:
0 <= n <= 5 * 10^6

Time complexity: O(n^2)
Space complexity: O(n)

*/

class Solution {

    int countPrimes(int n) {
        if (n<=2) {
            return 0;
        }
        
        int counter = 0;
        /* notPrimesArray: Array in which every cell represents whether 
        its index number is non-prime or not. Initially every number is 
        considered prime (default value: false), but the opposite might be 
        determined later. */
        boolean[] notPrimesArray = new boolean[n];
        
        for (int i=2; i<n; i++) {
            /* Any product of i>=2 multiplied by any integer j>=2 is not prime.
            So the corresponding value of i*j in the array is changed to true. 
            This will only affect cells with an index number higher than the 
            current i, as i*j>i for any j>=2.*/
            for (int j=2; i*j<n; j++) {
                notPrimesArray[i*j] = true;
            }

            /* If a number is non-prime, the counter is updated. */
            if (notPrimesArray[i]==false) {
                counter++;
            }
        }

        return counter;
    }

};
