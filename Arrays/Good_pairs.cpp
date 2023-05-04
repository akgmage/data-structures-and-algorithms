/* Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : Algorithms
Problem :  Find Number of Good Pairs in Go
Issue Number : #529
Problem statement : Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

-------------------------------------------------------------------------//C++ code begins here---------------------------------------------------------------------------------
//Array: Find Number of Good Pairs in Go

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    vector<int> v;
    map<int,int> m;
    for(int i=0;i<n;i++)
    {
        int x;
        cin>>x;
        v.push_back(x);
        m[x]++;
    }
    int count = 0;
    for(auto it:m)
    {
        count = count + (it.second-1)*(it.second)/2;
    }
    cout<<count<<endl;
    return 0;
}
