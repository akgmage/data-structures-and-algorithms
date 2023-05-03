/*
	Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

	Implement the Solution class:
	Solution(int[] nums) Initializes the object with the integer array nums.
	int[] reset() Resets the array to its original configuration and returns it.
	int[] shuffle() Returns a random shuffling of the array.

	Input
	["Solution", "shuffle", "reset", "shuffle"]
	[[[1, 2, 3]], [], [], []]
	Output
	[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

	Constraints:
	> 1 <= nums.length <= 50
	> -106 <= nums[i] <= 106
	> All the elements of nums are unique.
	> At most 104 calls in total will be made to reset and shuffle.
*/

/*
    APPROACH

    1. Use two lists to store the original nums array. 
    2. We can keep one array as it is and return it whenever the reset() function is called.
    3. We use the second list to shuffle the permutation of elements and return a shuffled array when shuffle() function is called.
    4. For shuffling, choose 2 indices on random basis from the array and swap them. Repeat for n times. (n=size of the array)

*/
// O(N) Time-Complexity and O(N) Space-Complexity Solution
class Solution {
public:
    // lets make 2 variables, one to store the shuffled version of the given array and the other to store the original version
    vector<int> shuffled;
    vector<int> original;
    Solution(vector<int>& nums) {
        // Push the elements of given array to required variables as Initialization 
        for(int i=0;i<nums.size();i++)
        {
            shuffled.push_back(nums[i]);
            original.push_back(nums[i]);
        }
    }
    
    vector<int> reset() {
        // Return the variable storing the original version of the array
        return original;
    }
    
    vector<int> shuffle() {
        int N=shuffled.size();
        // shuffle the variable storing the shuffled version of the array randomly
       for(int i=0;i<N;i++)
       {
           int ind1=rand()%N;
           int ind2=rand()%N;
           swap(shuffled[ind1],shuffled[ind2]);
       } 
       // return the newly shuffled version as answer
       return shuffled;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * vector<int> param_1 = obj->reset();
 * vector<int> param_2 = obj->shuffle();
 */