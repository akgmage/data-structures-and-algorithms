class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int target = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                count++;
            }
            else if(nums[i]!=target){
                count--;
            }
            if(count==0){
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}