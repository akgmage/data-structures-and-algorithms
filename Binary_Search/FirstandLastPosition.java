/*
 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value
If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

How this Code Works?
The firstPos method will give the starting position of the target element. We will find the mid and check if the mid element  is equals to the target we will check if previous element is equal to target or not if it is then place low to mid-1 if not   just update the high to mid-1. Next condition is if the element is greater then target it means we have to search in the left side of array hence high=mid-1.And last condition if the element is less than the target do low=mid-1. If this method returns Integer.MAX_VALUE if means element is not present. Hence return {-1,-1} as answer.

The lastPost method works same way as the above method. Passed extra paramter of low because it's now already clear that from  where we have to start as we already got the first index.
 */
class FirstandLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
    int a=firstPos(nums, target);
    int b=0;
    if(a!=Integer.MAX_VALUE){
      b=lastPos(nums,target,a);
    }else{
        return new int[]{-1,-1};
    }
    return new int[]{a,b};
  }
  private  int firstPos(int[] arr,int target){
    int ans=Integer.MAX_VALUE,low=0,high=arr.length-1;

    while(low<=high){
      int mid=low+(high-low)/2;

      if(arr[mid]==target){
        ans=Math.min(ans,mid);
        if(mid>0 && arr[mid-1]==target) low=mid-1;
         high=mid-1;
      }else if(arr[mid]>target){
         high=mid-1;
      }else if(arr[mid]<target){
         low=mid+1;
      }
    }
    return ans;
  }
  private  int lastPos(int[] arr,int target,int low){
    int ans=Integer.MIN_VALUE,high=arr.length-1;
    while(low<=high){
      int mid=low+(high-low)/2;
      if(arr[mid]==target){
        ans=Math.max(ans,mid);
        if(mid+1<arr.length && arr[mid+1]==target) high=mid+1;
        low=mid+1;
      }else if(arr[mid]>target){
        high=mid-1;
      }else{
        low=mid+1;
      }
    }
     return ans;
  } 
}
