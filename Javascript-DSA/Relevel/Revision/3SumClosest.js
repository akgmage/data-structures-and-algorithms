// https://leetcode.com/problems/3sum-closest/
function threeSumClosest(array, targetSum) {

    array.sort((a, b) => a - b);
	console.log(array);

    let result = Infinity;

	for(let i = 0; i < array.length - 2; i++) {

		let left = i + 1;
		let right = array.length - 1;

		while(left < right) {
			const sum = array[left] + array[right] + array[i];

			if(sum == targetSum) return sum;
			else sum < targetSum ? left++ : right--;

			if(Math.abs(targetSum - sum) < Math.abs(targetSum - result))
			{
				result = sum;
			}
		}
	}
	return result;
}

const nums = [-1,2,1,-4]; 
const target = 1;

console.log(threeSumClosest(nums, target));