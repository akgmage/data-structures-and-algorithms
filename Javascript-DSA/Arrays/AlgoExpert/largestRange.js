//? https://www.algoexpert.io/questions/Largest%20Range

//! O(n) time | O(n) space
function largestRange(array) {
	let bestRange = [];
	let longestRange = 0;
	const nums = {};

	for(const num of array) {
		nums[num] = true;
	}

	for(const num of array) {
		if(!(nums[num])) continue;
		nums[num] = false;
		let currentLength = 1;
		let left = num - 1;
		let right = num + 1;
		
		while(left in nums) {
			nums[left] = false;
			currentLength++;
			left--;
		}

		while(right in nums) {
			nums[right] = false;
			currentLength++;
			right++;
		}

		if(currentLength > longestRange) {
			longestRange = currentLength;
			bestRange = [left + 1, right - 1];
		}
	}
	return bestRange;
}

// let array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6];
// let array = [1, 1, 1, 3, 4];
let array = [0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6, 13, 14, -2];
console.log(largestRange(array));