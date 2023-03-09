/*Binary Search in an Infinite array in Java
 * Given an array whose size is not fixed,find the index of the target element in the array.
 * EXAMPLE: [5,15,34,56,77,87...] (array can be of any size)
 * Target = 56;
 * Output: 3;
 * 
 * APPROACH:
 * The approach will be similar to normal binary search but in reverse order 
 * ie; For the  start and end value, find the range which will be taking the target in the range.
 * We will not specify the array length since the array size is infinity.
 * Send the start and end value to the search function and return the position of the element.
 * 
 */

public class InfinityArray {
    public static void main(String[] args){
        int[] nums = {2,5,7,9,14,45,56,77,89,101};// can be of any size
        int target = 56;
        System.out.println(range(nums,target));
    }

    public static int range(int[] nums,int target){
        int start=0,end=1;
        while(target > nums[end]){
            int temp = end +1;
            end = end + (end-start)*2;
            start = temp;
        }
        return search(nums,target,start,end);
    }
    public static int search(int[] nums, int target,int start,int end) {
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
}
