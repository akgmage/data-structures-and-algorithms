/*
	Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
	
	Input: nums = [-4,-1,0,3,10]
	Output: [0,1,9,16,100]
	
	Input: nums = [-7,-3,2,3,11]
	Output: [4,9,9,49,121]
	
	Constraints:
	>  1 <= nums.length <= 104
	>  -104 <= nums[i] <= 104
	>  nums is sorted in non-decreasing order.
*/

// The optimised approch will be to use two pointer from both the ends and then compare the two numbers and the greter number square will be placed in its right position and move the pointer accordinly until they meet in the middle. 
// O(N) Time Complexity
// O(N) Space Complexity

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n= nums.size();
        vector<int> ans(n);  

        int neg = 0, pos = n-1;
        int k = n-1;   

        while( neg<=pos ){
            if(abs(nums[neg]) >= nums[pos]){
                ans[k--] = nums[neg]*nums[neg++];
            }
            else{
                ans[k--] = nums[pos]*nums[pos--];
            }
        }

        return ans; 
    }
};