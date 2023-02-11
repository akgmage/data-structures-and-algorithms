/* Finding the index of the first occurence of a number in a sorted array: 
Given a sorted array and a number x,find the first occurence of x in the 
array. If the element is not found , return -1.

Solve it in O(logN) complexity

Example :

INPUT :  nums = [1,5,7,7,7,9,11,14],  target = 7
OUTPUT: 2

INPUT :  nums = [1,2,4,6,45,55],  target = 20
OUTPUT: -1

Approach:

  # Approach will be similar to other binary search problems, but there is a need to find first occurence,
    So ,if the element found is equal to target, make the end pointer point before of the mid value.

  # Once the condition violates and loop terminates ,check if the target value is equal to the start pointer value.
    if it is equal, return the start pointer. if it is not return -1;

*/



public class FirstOccurence{
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

    public static void main(String[] args){
        int[] arr = {1,5,7,7,7,9,11,14};
        int target = 7;
        System.out.print(firstOccurence(arr,target));

    }
}