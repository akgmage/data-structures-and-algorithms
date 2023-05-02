/*
	Write a function that takes in an array of integers and returns the length of the longest peak in the array.
	A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak), at which point they become strictly decreasing. At least three integers are required to form a peak.

	Sample Input  = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
	Output = 6 // 0, 10, 6, 5, -1, -3
*/
#include <bits/stdc++.h>
using namespace std;
class Solution{
 public:
    int maxPeakLength(vector<int> nums)
    {
		
		// Intitialize the required variables
        bool beforePeak=true;
        int maxLen=0;
        int curLen=0;
		
		// Traverse through the array to find peaks
        for(int i=0;i<nums.size();i++)
        {
		
            if(beforePeak && nums[i]<nums[i+1])
            {
			// We are in the former strictly increasing part of the peak
                curLen++;
            }
            else if(beforePeak && nums[i]==nums[i+1])
            {
			// No peak formed as former part is not strictly Increasing anymore
                curLen=0;
            }
            else if(beforePeak && nums[i]>nums[i+1])
            {
			// Transiting into the latter strictly decreasing part of the peak
                if(curLen<1){
                    curLen=0;
                    beforePeak=true;
                    }
                curLen++;
                beforePeak=false;
            }
            else if(!beforePeak && nums[i]<nums[i-1])
            {
			// We are in the latter strictly decreasing part of the peak
                curLen++;
                maxLen=max(maxLen,curLen);
            }
            else{
			// We are out of the latter strictly decreasing part of the peak 
                curLen=0;
                if(nums[i]>nums[i-1]) i-=2;
                else if(nums[i]==nums[i-1]) i-=1;
                beforePeak=true;
            }
        }

	// Return the final answer
        return maxLen;
    }
};