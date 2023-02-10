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
