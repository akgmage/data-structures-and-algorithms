//! https://www.algoexpert.io/questions/Two%20Number%20Sum
//! O(nlogn) time | O(1) space
// function twoNumberSum(array, targetSum) {
// 	array.sort((a, b) => a - b);
// 	let left = 0;
// 	let right = array.length - 1;
// 	while( left < right) {
// 		const currentSum = array[left] + array[right];
// 		if(currentSum == targetSum) {
// 			return [array[left], array[right]];
// 		} else if(currentSum < targetSum) {
// 			left++;
// 		} else if(currentSum > targetSum) {
// 			right--;
// 		}
// 	}
// 	return [];
// }

//! O(n) time | O(n) space 
function twoNumberSum(array, targetSum) {
	const nums = {};
for(let i = 0; i < array.length; i++) {
	const nums = {};
	// for(const num of array) {
	// 	const potentialMatch = targetSum - num;
	// 	if(potentialMatch in nums) {
	// 			return [potentialMatch, num];
	// 	}else {
	// 		nums[num] = true;
	// 	}
	// }
	// return [];
	for(let i = 0; i < array.length; i++) {
		const num = array[i];
		const potentialMatch = targetSum - num;
		if(potentialMatch in nums) {
			console.log(nums)
			return [nums[potentialMatch].index, i];
		}
		else {
			nums[num] = {num};
			nums[num].index = i
		}
		// console.log(nums)
		}
	return [];
	}	
}

//! O(n^2) time | O(1) space
// function twoNumberSum(array, targetSum) {
// 	for(let i = 0; i < array.length; i++) {
// 		const firstNum = array[i];
// 		for(let j = 0; j < array.length; j++) {
// 			const secondNum = array[j];
// 			if(firstNum + secondNum == targetSum) {
// 				return [firstNum, secondNum];
// 			}
// 		}
// 	}
// 	return [];
// }

const array = [3,3];
const target = 6;


console.log(twoNumberSum(array, target));