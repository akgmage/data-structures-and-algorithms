#include <vector>
#include<iostream>

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
