// Problem Name-4Sum

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        set<vector<int>> st;
        int n = nums.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int start = j+1,end = n-1;
                while(start<end){
                    long long crSum = (long long)nums[i]+nums[j]+nums[start]+nums[end];
                    if(crSum == target)
                    {
                        st.insert({nums[i],nums[j],nums[start],nums[end]});
                        end--;
                    }
                    else if(crSum>target) end--;
                    else start++;
                }
            }
        }
        vector<vector<int>> ans(st.begin(),st.end());
        return ans;
    }
  int main(){
    int n;
    cin>>n;
    vector<int>nums;
    int target;
    cin>>target;
    vector<vector<int>>res;
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    res=fourSum(nums,target);
     for(int i = 0; i < res.size(); i++){
        cout<<res[i];
    }
    return 0;
}

