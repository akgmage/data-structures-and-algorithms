//! O(nk) time | O(n + k) space - n is the total
//! number of array elements and k is the number or arrays
function mergeSortedArrays(arrays) {
 const sortedList = [];
	const elementIdxs = arrays.map(() => 0);
	while(true) {
		const smallestItems = [];
		for(let arrayIdx = 0; arrayIdx < arrays.length; arrayIdx++) {
			const relevantArray = arrays[arrayIdx]; //? [1, 5, 9, 21]
			const elementIdx = elementIdxs[arrayIdx]; //? 0
			if(elementIdx === relevantArray.length) continue; 
			smallestItems.push( {
				arrayIdx,
				num: relevantArray[elementIdx],
			});
		}
        console.log(smallestItems.length);
        console.log(smallestItems);
			if(smallestItems.length === 0) break;
			const nextItem = getMinValue(smallestItems);
			sortedList.push(nextItem.num);
			elementIdxs[nextItem.arrayIdx]++;
	}
	return sortedList;
}

function getMinValue(items) {
	let minValueIdx = 0;
	for(let i = 1; i < items.length; i++) {
		if(items[i].num < items[minValueIdx].num ) minValueIdx = i;
	}
	return items[minValueIdx];
}

let arrays = [
    [1, 5, 9, 21],
    [-1, 0],
    [-124, 81, 121],
    [3, 6, 12 ,20, 150]
];

console.log(mergeSortedArrays(arrays));