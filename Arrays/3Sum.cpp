/* Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Add Three number sum in C++
Issue Number : #242
Problem statement : 3Sum

Explanation of the below cpp code :

The code first sorts the input array in ascending order. Then, it iterates through the array and uses the two-pointer technique to find the remaining two elements that add up to the negative of the current element.

We use two pointers, one at the beginning and one at the end of the remaining array after fixing the current element. If the sum of the three elements is less than zero, we increase the left pointer to increase the sum. If the sum is greater than zero, we decrease the right pointer to decrease the sum. If the sum is zero, we add the triplet to the result vector, and skip duplicate elements by increasing the left pointer and decreasing the right pointer until they point to different elements.

The time complexity of the code is O(n^2), where n is the length of the input array. The sorting step takes O(n log n) time, and the nested loop takes O(n^2) time in the worst case. However, we skip many iterations of the loop using the two-pointer technique, making the actual running time faster than the worst-case time complexity.
*/
-----------------------------------------------------------------------------------------------------------//C++ code begins here------------------------------------------------------------------------------------------------------------------------------------------------------------

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> result;
    int n = nums.size();
    sort(nums.begin(), nums.end()); // Sort the input array

    // Fix the first element and use two pointer technique to find the remaining two elements
    for (int i = 0; i < n - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate elements

        int l = i + 1, r = n - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum < 0) {
                l++; // Increase left pointer to increase the sum
            } else if (sum > 0) {
                r--; // Decrease right pointer to decrease the sum
            } else {
                result.push_back({nums[i], nums[l], nums[r]});
                // Skip duplicate elements
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            }
        }
    }
    return result;
}

int main() {
    vector<int> nums = {-1, 0, 1, 2, -1, -4};
    vector<vector<int>> result = threeSum(nums);
    for (vector<int> triplet : result) {
        for (int x : triplet) {
            cout << x << " ";
        }
        cout << endl;
    }
    return 0;
}
