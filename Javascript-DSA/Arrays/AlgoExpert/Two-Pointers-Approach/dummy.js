var threeSum = function(nums) {
    
if(nums.length  < 3) return [];
    
    const triplets = [];

    nums.sort((a, b) => a - b);
    
    for(let i = 0; i < nums.length - 2; i++) {
        
        if( (i > 0) && nums[i] == nums[i - 1]){
            continue;
        }
        let left = i + 1;
        let right = nums.length - 1;
        
        while(left < right) {
            
             const currentSum = nums[i] + nums[left] + nums[right];
            
            if(currentSum == 0) {
                triplets.push([nums[i], nums[left], nums[right]]);
                while(nums[left] == nums[left + 1]) left++;
                while(nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
             if(currentSum < 0) {
                left++;
            } else if(currentSum > 0) {
                right--;
            }
        }  
    }
return triplets;
};

console.log(threeSum([0,0,0,0]));