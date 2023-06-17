/*
	Given an array of integers between 1 and n, inclusive, where n is the length of the array, write a function
	that returns the first integer that appears more than once (when the array is read from left to right).

	Sample Input = [2, 1, 5, 2, 3, 3, 4]
	Output : 2

	Please provide O(n) time and O(1) space solution along with O(n) time and O(n) space solution
*/

#include <bits/stdc++.h>
using namespace std;

class Solution{
public:
    // O(N) time complexity and O(N) Space Complexity Solution
    int findDuplicate1(vector<int>& nums)
    {
        int N=nums.size();
    
        // Use Vector Instead of Unordered Set or Map for O(1) extraction time complexity
        vector<bool> trk(N,false);
    
        for(int i=0;i<N;i++)
        {
            if(trk[nums[i]]==true) return nums[i];
            trk[nums[i]]=true;
        }
        return -1;
    }

    // O(N) time complexity and O(1) Space Complexity Solution
    int findDuplicate2(vector<int>& nums)
    {
        int N=nums.size();
        for(int i=0;i<N;i++)
        {
            if(nums[abs(nums[i])]<0) return nums[i];
            nums[abs(nums[i])]*=-1;
        }
        return -1;
    }
};