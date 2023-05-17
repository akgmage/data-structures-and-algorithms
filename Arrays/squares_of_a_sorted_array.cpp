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

/*class Solution {
public:
    int N=10001;
    vector<int> sortedSquares(vector<int>& nums) {
        // Initialize variables
        vector<int> trk(N,0);

        // Store the frquency of the absolute of each number from the list
        for(int i=0;i<nums.size();i++)
        {
            trk[abs(nums[i])]++;
        }

        //Traverse the frequency list trk and store the squares of the numbers as per their frequency
        for(int i=0;i<N;i++)
        {
            if(trk[i]>0)
            {
                int square=i*i;
                while(trk[i])
                {
                    ans.push_back(square);
                    trk[i]--;
                }
            }
        }

        // Return the final ans
        return ans;
    }
};
*/
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n); // Create a vector to store the squared values
        int left = 0, right = n - 1; // Initialize two pointers at the start and end of the array

        for (int i = n - 1; i >= 0; i--) {
            if (abs(nums[left]) > abs(nums[right])) {
                // If the absolute value of the number at the left pointer is greater than the absolute value of the number at the right pointer
                res[i] = nums[left] * nums[left]; // Square the number at the left pointer and store it in the result array
                left++; // Move the left pointer to the right
            } else {
                // If the absolute value of the number at the left pointer is less than or equal to the absolute value of the number at the right pointer
                res[i] = nums[right] * nums[right]; // Square the number at the right pointer and store it in the result array
                right--; // Move the right pointer to the left
            }
        }

        return res; // Return the result array
    }
};
