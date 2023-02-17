/* Floor of an element in a sorted array
    You are given a sorted array nums and a target . 
    Find the index of the greatest element that is less than or equal to target

    EXAMPLES:
        INPUT :  nums = [2,4,5,7,9,11,18,25],  target = 18
        OUTPUT: 6

        INPUT :  nums = [2,4,5,7,9,11,18,25],  target = 10
        OUTPUT: 4

    APPROACH :
        We will implement this problem using BinarySearch since the array is sorted and will be similar to ceil
        but with slight modification
        
  */

  
public class FloorOfTarget{

    public static int search_floor(int[] nums,int target){
        int start = 0,end = nums.length-1;
        while(start <=end){
        int mid = start +(end-start)/2;
        if(nums[mid]==target){
            return mid;  // returns the target
        }
        else if(nums[mid] > target){
            end = mid-1;
        }
        else{
            start = mid +1;
        }
    }
    return end; // returns the nearest element to target if the target is not found
    }
    public static void main(String[] args){
        int[] nums = {2,4,5,7,9,11,18,25};
        int target = 10;  // output will be 4 in this case.
        System.out.print(search_floor(nums,target));
}
}
