/*
Example:
Input: nums = [4,14,2]
Output: 6

Explanation: 
In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Detailed Explanation:
The totalHammingDistance function takes a reference to a vector of integers nums, and returns the total Hamming distance between all possible pairs of elements in the vector.

In the function, we initialize the answer ans to 0, and the size of the vector n is obtained using the size() method of the vector. We then loop through all 32 bits (since we are dealing with 32-bit integers), and for each bit position i, we count the number of elements in nums with the i-th bit set by looping through all elements and checking if the bit is set using bitwise AND operator &.

The count c is then multiplied by (n-c), which gives the number of pairs with different bits at the i-th position. This count is added to the answer ans. Finally, the function returns the total Hamming distance.
The main function is just an example usage, where we create a vector nums and call the totalHammingDistance method of a Solution object to get the total Hamming distance between all possible pairs of elements in nums.
*/
// code:

#include<iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i < 32; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                if((nums[j] & (1 << i))) {
                    c++;
                }
            }
            ans += (c * (n - c));
        }
        return ans;
    }
};

int main() {
    // Example usage
    vector<int> nums = {4, 14, 2};
    Solution s;
    int result = s.totalHammingDistance(nums);
    return 0;
}

