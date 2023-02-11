
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
#include<bits/stdc++.h>

class Solution {
public:
    int trap(vector<int>& height) {    
        int len = height.size(), result = 0;
        if(len == 0) return 0;
        int low = 0, high = len - 1, leftmax = 0, rightmax = 0;
        while(low <= high){
            if(height[low] < height[high]){
                if(height[low] > leftmax)
                    leftmax = height[low];
                else
                    result += leftmax - height[low];
                low++;
            }
            else{
                if(height[high] > rightmax)
                    rightmax = height[high];
                else
                    result += rightmax - height[high];
                high--;
            }    
        }
        return result;
    }    
};