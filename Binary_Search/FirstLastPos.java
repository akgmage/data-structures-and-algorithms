/* Given a sorted array arr containing n elements with possibly duplicate elements, 
the task is to find indexes of first and last occurrences of an element x in the given array. 

Example 1: Input: arr [] = [ 1, 3, 5, 5, 5, 5, 67, 123, 125 ] , target = 5
OUTPUT: [2 5]
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5.

Example 2: Input: arr[] = [1,2,3,,5,6,7,8],target = 4
OUTPUT: [-1,-1]

APPROACH:
    #We will separately write methods for first occurence and last occurence of the element 

    # Follows the standard binary search algorithm with little moddification for first and last occurence
    # For the first occurence , return the start index at the end of the loop
    # For the last occurence , return the end index at the end of loop*/
import java.util.*;
public class FirstLastPos{
    public static int firstOccurence(int[] arr,int target){
        int start = 0,end=arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid]== target){
                end = mid -1;
            }
            else if(arr[mid] > target){
                end = mid -1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
        }
        if(start < arr.length && arr[start] == target){
            return start;
        }
        else{
            return -1;
        }
    }

    public static int lastOccurence(int[] arr,int target){
        int start = 0,end=arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid]== target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid -1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
        }
        if(end >= 0 && arr[end] == target){
            return end;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,5,7,7,7,9,11,14};
        int target = 7;
        int[] result = new int[2];
        result[0] = firstOccurence(arr,target);
        result[1] = lastOccurence(arr,target);
        System.out.println(Arrays.toString(result));

    }
}