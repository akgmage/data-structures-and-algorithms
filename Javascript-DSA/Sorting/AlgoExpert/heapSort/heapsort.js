//! Best: O(nlogn) time | O(1) space
//! Best: O(nlogn) time | O(1) space
//! Worst: O(nlogn) time | O(1) space

function heapSort(array) {
	buildMaxHeap(array);
	for(let endIdx = array.length - 1; endIdx > -1; endIdx--) {
		swap(0, endIdx, array);
		siftDown(0, endIdx - 1, array);
	}
	return array;
}

function buildMaxHeap(array) {
	let firstParentIdx = Math.floor((array.length - 2) / 2);
	for(let currentIdx = firstParentIdx; currentIdx > -1; currentIdx--) {
		siftDown(currentIdx, array.length - 1, array);
	}
}

function siftDown(currentIdx, endIdx, heap) {
	let childOneIdx = currentIdx * 2 + 1;
	while(childOneIdx <= endIdx) {
		let childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
		let idxToSwap;
		if(childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
			idxToSwap = childTwoIdx;
		} else {
			idxToSwap = childOneIdx;
		}
		if(heap[idxToSwap] > heap[currentIdx]) {
			swap(idxToSwap, currentIdx, array);
			currentIdx = idxToSwap;
			childOneIdx = currentIdx * 2 + 1;
		} else {
			return;
		}
	}
}

function swap(i, j, heap) {
	[ heap[i], heap[j] ] = [ heap[j], heap[i] ];
}


let array = [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41];
console.log(heapSort(array));