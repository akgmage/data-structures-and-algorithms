//! https://www.algoexpert.io/questions/Sorted%20Squared%20Array
//! O(nlogn) time | O(n) space
function sortedSquaredArray(array) {
	const sortedSquares = new Array(array.length).fill(0);
	const smallerValueIdx = 0;
	const largerValueIdx = array.length - 1;
	for(let idx = array.length - 1; idx >= 0; idx--) {
		const smallerValue = array[smallerValueIdx];
		const largerValue = array[largerValueIdx];
		if(Math.abs(smallerValue) > Math.abs(largerValue)) {
			sortedSquares[idx] = smallerValue * smallerValue;
			smallerValueIdx++;
		} else {
			sortedSquares[idx] = largerValue * largerValue;
			largerValueIdx--;
		}
	}
	return sortedSquares;
}


//! O(n) time | O(n) space
function sortedSquaredArray(array) {
  const sortedSquares = new Array(array.length).fill(0);
  for(let idx =0; idx < array.length; idx++) {
	  const value = array[idx];
	  sortedSquares[idx] = value * value;
  }
  sortedSquares.sort((a, b) => a - b);
  return sortedSquares;
}
