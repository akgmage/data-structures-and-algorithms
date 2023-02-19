import java.util.HashMap;
/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 

Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res= new int[nums.length];
          int count=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ; i++)
        {
            for(int j = 0 ; j < nums.length ; j++)
            {
                if(nums[j] < nums[i])
                    count++;
                
            }
            hm.put(nums[i],count);
            count = 0;
        }
        
        for(int i = 0 ;i < nums.length ; i++)
            res[i] = hm.get(nums[i]);
            
        return res;
    }
}
class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,2,7};
        Solution s = new Solution();
        int ans[] = s.smallerNumbersThanCurrent(arr);
        for (int i = 0 ; i < ans.length ; i++){
        System.out.println(ans[i]);
        }
        
    }
}