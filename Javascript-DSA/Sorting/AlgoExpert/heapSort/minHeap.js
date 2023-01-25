class MinHeap {
	constructor(array) {
		this.heap = this.buildHeap(array);
	}
	//! O(n) time | O(1) space
	buildHeap(array) {
		const firstParentIdx = Math.floor((array.length - 2) / 2);
		for(let currentIdx = firstParentIdx; currentIdx > -1; currentIdx--) {
			this.siftDown(currentIdx, array.length - 1, array);
		}
	}
	//! O(logn) time | O(1) space
	siftDown(currentIdx, endIdx, heap) {
		let childOneIdx = currentIdx * 2 + 1;
		while(currentIdx <= endIdx) {
			const childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2: -1;
			let idxToSwap;
			if(childTwoIdx != -1 && heap[childTwoIdx] < heap[childOneIdx]) {
				idxToSwap = childTwoIdx;
			} else {
				idxToSwap = childOneIdx;
			}
			if(heap[idxToSwap] < heap[currentIdx]) {
				this.swap(idxToSwap, currentIdx, heap);
				currentIdx = idxToSwap;
				childOneIdx = currentIdx * 2 + 1;
			} else {
				return;
			}

		};
	}
	//! O(logn) time | O(1) space
	siftUp(currentIdx, heap) {
		let parentIdx = Math.floor( (currentIdx - 1) / 2 );
		while(currentIdx > 0 && heap[currentIdx] < heap[parentIdx]) {
			this.swap(currentIdx, parentIdx, heap);
			currentIdx = parentIdx;
			parentIdx = Math.floor( (currentIdx - 1) / 2 );
		}
	}
	//! O(1) time | O(1) space
	peek() {
		return this.heap[0];
	}
	//! O(logn) time | O(1) space
	remove() {
		this.swap(0, this.heap,length - 1, this.heap);
		const valueToRemove = this.heap.pop();
		this.siftDown(0, this.heap.length - 1, this.heap);
		return valueToRemove;
	}
	//! O(logn) time | O(1) space
	insert(value) {
		this.heap.push(value);
		this.siftUp(this.heap.length - 1, this.heap);
	}
	//! O(1) time | O(1) space
	swap(i, j, heap) {
	[ heap[i], heap[j] ] = [ heap[j], heap[i] ];
	}
}

let array = [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41];
const heap =  new MinHeap(array);