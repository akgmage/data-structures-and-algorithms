
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]



#include <bits/stdc++.h>
using namespace std;

void sortColors(vector<int> &nums)
{
    // created 3 variables start , low and end which are pointing start and low which are pointing to first index , end is pointing to last index .

    int start = 0, low = 0, end = nums.size() - 1;
    while (low <= end)
    {
        if (nums[low] == 0) // checking if element of low is 0 . If yes then  swap to start and low .
        {
            swap(nums[low], nums[start]);
            start++, low++;
        }
        else if (nums[low] == 1) // checking if element at low index is 1 , If yes then increase the index by 1 .
        {
            low++;
        }
        else // else swap the element of low index to end .
        {
            swap(nums[low], nums[end]);
            end--;
        }
    }
}
int main()
{
    vector<int> nums{2, 0, 2, 1, 1, 0};
    sortColors(nums);

    // Printing array's elements ..
    for (auto i : nums)
    {
        cout << i << " ";
    }
}
