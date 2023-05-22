import java.util.*;

class two_sum {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=1, gap = 1;
        while(i<nums.length){
            if(nums[i]+nums[j]== target){
                return new int[]{i,j};
            }
            if(j>=nums.length-1){
                gap++;
                j = gap;
                i=0;
            }
            else{
                i++;
                j++;
            }
        }
        return new int[]{-1,-1};
    }
}

    public static void main(String[] args) {
        int[] nums = {1, 3, -3, 5, 4, 6};
        int target = 6;

        int[] pair = twoSum(nums, target);

        System.out.println("The Two Numbers positions are " + pair[0] + " " + pair[1] + " That sum up to "+ target);
    }
}

//---------------Explanation---------------------

//       Problem Statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//      Approach:
//      1. We have Two pointers, `i` and `j` that start from `0` and `1`
//      2. We loop until i reaches the end, We keep moving j up in each interation.
//      3. Increase a variable `gap` for each time j reaches the end. We also move i one position up each time j reaches the end.
//      4. If we find a pair, We return it.
//      5. If `i` reaches the end, that means a solution doesnt exist. So we return [-1,-1].