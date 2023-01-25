//? https://www.algoexpert.io/questions/First%20Duplicate%20Value
// https://leetcode.com/problems/find-the-duplicate-number/
//! O(n) time | O(1) space
function firstDuplicateValue(array) {
	for(const value of array) {
		const absValue = Math.abs(value);
		if(array[absValue - 1] < 0 ) return absValue;
		array[absValue - 1] *= -1;
 	}
	return - 1;
}
//! O(n) time | O(n) space
function firstDuplicateValue(array) {
const seen = new Set();
	for(const value of array) {
		if(seen.has(value)) return value;
		seen.add(value);
	}
  return -1;
}
//! O(n^2) time | O(1) space
function firstDuplicateValue(array) {
let minimumSecondIndex = array.length;
	for(let i = 0; i  < array.length; i++) {
		const value  = array[i];
		for(let j = i  + 1;  j < array.length; j++) {
			const valueToCompare = array[j];
			if(value == valueToCompare) {
				minimumSecondIndex = Math.min(minimumSecondIndex, j);
			}
		}
	}
	if(minimumSecondIndex == array.length) return -1;
	
	return array[minimumSecondIndex];
}

