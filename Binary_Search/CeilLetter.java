/* Ceiling of an element in a sorted array
    You are given a sorted array of characheters and a target . 
    Find the smallest character that is greater than  target.

    Note : The letters wrap around in the array
    ie, for an array ['c','d'], if target = 'z', then return first element in the array('a')


    EXAMPLES:
        INPUT :  nums = ['a'.'b','c''g'.'l'],  target = 'k'
        OUTPUT: 'l'

        INPUT :  nums = ['a'.'b','c''g'.'l'],  target = 'l'
        OUTPUT: 'a'

    APPROACH :
        Approach will be similar to that of ceil of target except we don't need to check for equality.

        We will implement this problem using BinarySearch since the array is sorted. 
        
  */



public class CeilLetter{
    public static int ceil(char[] arr,int target){
         int start = 0,end = arr.length-1;
         while(start <=end){
          int mid = start +(end-start)/2;
          if(arr[mid] > target){
            end = mid-1;
          }
          else{
            start = mid +1;
          }
    }
    return start % arr.length ; // returns the first element if no element is greater than the target.
    }

     public static void main(String[] args){
        
        char[] arr = {'a','c','d','h','m'};
        int target = 'm';
        int index= ceil(arr,target);
        System.out.println(arr[index]);
}
    }