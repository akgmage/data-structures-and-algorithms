// https://leetcode.com/problems/3sum/
// O(N(log(N)) time | O(1) space
var threeSum = function(nums) {
        const triplets = [];
        nums.sort((a, b) => a - b);
        for(let i = 0; i < nums.length - 2; i++) {
        if( (i > 0) && nums[i] == nums[i - 1]) {
        continue;
        }
        let left = i + 1;
        let right = nums.length - 1;

        while(left < right) {
        const currentSum = nums[i] + nums[left] + nums[right];
        if(currentSum == 0) {
        triplets.push([nums[i], nums[left], nums[right]]);
        while(left < right && nums[left] == nums[left + 1]) left++;
        while(left < right && nums[right] == nums[right - 1]) right--;
        left++;
        right--;
        } else if(currentSum < 0) {
        left++;
        } else if(currentSum > 0) {
        right--;
        }
        }
        }
        return triplets;
        };
        const array = [-1,0,1,2,-1,-4];

        console.log(threeSum(array));