#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

vector<int> zeroSumSubarray(vector<int>& nums) {
    vector<int> result;
    unordered_map<int, int> mp;
    int sum = 0;
    mp[0] = -1;
    
    for (int i = 0; i < nums.size(); i++) {
        sum += nums[i];
        if (mp.find(sum) != mp.end()) {
            result.push_back(mp[sum] + 1);
            result.push_back(i);
            break;
        }
        mp[sum] = i;
    }
    
    return result;
}

int main() {
    vector<int> nums = {4, 2, -3, 1, 6};
    vector<int> result = zeroSumSubarray(nums);
    if (result.empty()) {
        cout << "No zero sum subarray found." << endl;
    } else {
        cout << "Zero sum subarray found: ";
        for (int i = result[0]; i <= result[1]; i++) {
            cout << nums[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
