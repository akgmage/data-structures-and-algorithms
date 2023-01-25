//? https://www.algoexpert.io/questions/Smallest%20Difference
//! O(nlog(n) + mlog(m)) time | O(1) space
function smallestDifference(arrayOne, arrayTwo) {
arrayOne.sort((a, b) => a - b);
arrayTwo.sort((a, b) => a - b);
let idxOne = 0;
let idxTwo = 0;
let smallest = Infinity;
let current = Infinity;
let smallestPair = [];
while(idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
	let firstNum = arrayOne[idxOne];
	let secondNum = arrayTwo[idxTwo];
	if(firstNum < secondNum) {
		current = secondNum - firstNum;
		idxOne++;
	} else if(secondNum < firstNum) {
		current = firstNum - secondNum;
		idxTwo++;
	} else return [firstNum, secondNum];
	if(smallest > current) {
		smallest = current;
		smallestPair = [firstNum, secondNum];
	}
} return smallestPair;
}