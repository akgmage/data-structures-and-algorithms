/* BINARY SEARCH
   Problem Statement:
   Given an array of integers nums sorted in ascending order and a target ,
   You need to search the target in the array nums.
   If the target is found ,return the index position,else return -1

   Time complexity:
   WorstCase: O(log N)  N--> length of the array
   BestCase:  O(1)

   Example :
    Input: nums = [-5,-2,0,2,5,30], target = 2
    Output: 3
    Explanation : target 2 is found at index 3
*/

public class IndexPosition {

    // method for implementation of binary search
    public static int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            // if middle value is equal to target return the mid index
            if(nums[mid] == target){
                return mid;
            }
            // if mid value is greater than the target, search the left sub array
            else if(nums[mid] > target){
                end = mid - 1;
            }
            // if mid value is lesser than the target, search the right sub array
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return -1;  
    }
    public static void main(String[] args){
        //get input array and target value
        // you can also get input dynamically using Scanner class
        int [] array = {-5,-2,0,2,5,30};
        int target = 2;
        System.out.print(search(array,target));
    }
}