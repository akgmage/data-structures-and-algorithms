/**

 Time Complexity: O(n), Space Complexity O(n).

 Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 Input: nums = [-4,-1,0,3,10]
 Output: [0,1,9,16,100]

 Input: nums = [-7,-3,2,3,11]
 Output: [4,9,9,49,121]


 Input: nums = [2,3,11]
 Output: [4,9,121]

**/

class Solution {
    public int[] sortedSquares(int[] nums) {

        int hasNegative = -1; // -1  Indcating that are no negative values in the input array.
        int len = nums.length;

	  // Find the index of the last negative value.
        for(int i = 0; i < len; ++i)
        {
            if(nums[i] < 0)
            {
                nums[i] = Math.abs(nums[i]); // If there is a negative value make it positive.
                hasNegative = i;
            }
        }


        int []ans = new int[nums.length];

        if(hasNegative != -1) // check if the array have negative values
        {

	    /**
		If there are negative values,
                that's divide the input array into two halfs.
                both halfs are sorted in increasing order if:

	          -first half start from a and end at index 0, Where a is the index of the last negative value.
        	    -second half start from (b) and end at (size of the array  - 1 (n - 1)) [b, n-1] iclusive, Where b is the index a + 1.

                At every step we choose the minimun value between the vlaues at index a and b then,
                square the value and store it in array []ans.
	    **/
            int a = hasNegative, b = hasNegative + 1;
            int k = 0;

            while(a >= 0 && b < len)
            {
                if(nums[a] <= nums[b]) // Value at index a is the minimum value so we choosed.
                {
                    ans[k] = nums[a] * nums[a];
                    a--;
                }
                else
                {
                    ans[k] = nums[b] * nums[b];
                    b++;
                }
                k++;
            }

            while(a >= 0)
            {
                 ans[k++] = nums[a] * nums[a];
                 a--;
            }

            while(b < len)
            {
                 ans[k++] = nums[b] * nums[b];
                 b++;
            }
        }
        else  //If there are no negative values, the sloution is straight forward.
        {

            for(int i = 0; i < len; ++i)
                ans[i] = nums[i] * nums[i];
        }
        return ans;
    }

}