//https://leetcode.com/problems/4sum/
// https://www.youtube.com/watch?v=4ggF3tXIAp0

function fourSum(array, targetSum) {
    const quadruplets = [];
    array.sort((a, b) => a - b);
    const len = array.length;
    for(let i = 0; i < len; i++) {
        for(let j = i + 1; j < len; j++) {
            const currentSum = array[i] + array[j];
            const difference = targetSum - currentSum;
            
            let left = j + 1;
            let right = array.length- 1;

            while(left < right) {
                const twoSum  = array[left] + array[right];

                if(twoSum < difference) left++;
                else if(twoSum > difference) right--;
                else {
                    quadruplets[quadruplets.length] = [array[i], array[j], array[left], array[right]];

                    while(left < right && array[left] == quadruplets[quadruplets.length - 1][2]) left++;

                    while(left < right && array[right] == quadruplets[quadruplets.length - 1][3]) right--;
                }
            }
            while(j + 1 < len && array[j + 1] == array[j]) j++;
        }
        while(i + 1 < len && array[i + 1] == array[i]) ;
    }
    return quadruplets;
}


const nums =[1,0,-1,0,-2,2];
const target = 0;

console.log(fourSum(nums, target));