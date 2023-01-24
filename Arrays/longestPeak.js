//? https://www.algoexpert.io/questions/Longest%20Peak
//!  O(n) time | O(1) space
function longestPeak(array) {
	let longestPeakLength = 0;
	let i = 1;
	while(i < array.length - 1) {
		const isPeak = array[i - 1] < array[i] && array[ i + 1] < array[i];
		if(!isPeak) {
			i++;
			continue;
		}
		let leftIdx = i - 2;
	while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1] ) {
		leftIdx--;
	}
		let rightIdx = i + 2;
		while(rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
			rightIdx++;
		}
		const currentPeakLength = rightIdx - leftIdx - 1
		longestPeakLength = Math.max(longestPeakLength, currentPeakLength);
		i = rightIdx;
	} 
	return longestPeakLength;
}
