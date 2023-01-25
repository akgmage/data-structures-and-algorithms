// https://leetcode.com/problems/two-sum/submissions/

var twoSum = function(array, targetSum) {
    const nums = {};
   for(let i = 0; i < array.length; i++) {
		const num = array[i];
		const potentialMatch = targetSum - num;
		if(potentialMatch in nums) {
			console.log(nums);
			// return [nums[potentialMatch].index, i];
			return [nums[potentialMatch][1], i];
		}
		else {
			// nums[num] = {num};
			// nums[num].index = i
			nums[num] = [num];
			nums[num][1] = i;
		}
	}
	console.log(nums);
	return [];
};

console.log(twoSum([7,3,1,5], 12));
