
/*
 * Problem : Implement Binary Search using Recursion.
 * 
 * RECURSION : Function that calls itself is called recursion.
 * 
 * Algorithm:
 * 1) Get an sorted array and a target to be found in the array.
 * 2) Find the middle index by dividing the first and last element.
 * 3) If the middle element is equal to target , return the mid index.
 * 4) If the middle element is greater than the target , in the next recursive call make last element as mid-1
 * 5) If the middle element is smaller than the target , in the next recursive call make first element as mid+1
 * 6) If start is less than end ,ie,if the element not found , return -1.
 * 
 * Time complexity: worst case: O(logN) , N - size of the array.
 * 
 * Space Complexity: O(logN) (since we use stack for function calls)
 * 
 */


public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] arr = {1,2,5,89,99,101};
        int target = 1;
        System.out.println(binarySearch(arr , target,0 , arr.length-1));
    }

    static int binarySearch(int[] arr ,int target, int start , int end) {

       int mid = (start + end)/2;

       if (start > end) {
           return -1;
       }
       if (arr[mid] == target) {
           return mid;
       }

       else if (arr[mid] > target) {
           return binarySearch(arr , target , start , mid-1);
       }

       return  binarySearch(arr ,target , mid+1, end);

    }
}
