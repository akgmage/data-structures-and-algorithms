/*
	You're given a list of integers nums. Write a function that returns a boolean representing
	whether there exists a zero-sum subarray of nums

	Sample Input :  = [-5, -5, 2, 3, -2]
	Output : True
	The subarray [-5, 2, 3] has a sum of 0
*/
/*
Approach:

  A good way to approach this problem is to first think of a simpler version.
  How would you check if the entire array sum is zero?

  If the entire array does not sum to zero, then you need to check if there are
  any smaller subarrays that sum to zero. For this, it can be helpful to keep
  track of all of the sums from [0, i], where i is every index in the array.

  After recording all sums from [0, i], what would it mean if a sum is repeated?
*/
// Time and Space complexity : O(n) time | O(n) space - where n is the length of nums
/*
This implementation uses an unordered map to keep track of the prefix sum of the input array nums. 
We initialize the map with a key-value pair of 0 and -1, since a prefix sum of 0 indicates that the 
subarray from index 0 to -1 (i.e., an empty subarray) has a sum of 0. We then iterate through the 
input array nums, adding each element to the running sum sum and checking if the current sum is 
already in the map. If it is, then we've found a subarray whose sum is 0, so we add the starting and 
ending indices of the subarray to the result vector and break out of the loop.
If we reach the end of the loop without finding a zero sum subarray, then we return an empty vector.
Note that this implementation assumes that there is only one zero sum subarray in the input array. 
If there could be multiple zero sum subarrays, then we would need to modify the implementation to 
return all of them.
*/
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
