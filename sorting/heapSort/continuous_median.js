class ContinuousMedianHandler {
  constructor() {
    this.lowers = new Heap(MAX_HEAP_FUNC, []);
	this.greaters = new Heap(MIN_HEAP_FUNC, []);
    this.median = null;
  }

//! O(logn) time | O(n) space
  insert(number) {
    if(!this.lowers.length || number < this.lowers.peek()){
		   this.lowers.insert(number);
    } else {
			this.greaters.insert(number);
		}
		this.rebalanceHeaps();
		this.updateMedian();
	}

 rebalanceHeaps() {
	 if(this.lowers.length - this.greaters.length === 2) {
		 this.greaters.insert(this.lowers.remove());
	 } else if(this.greaters.length - this.lowers.length === 2) {
		 this.lowers.insert(this.greaters.remove());
	 }
 }
	updateMedian() {
		if(this.lowers.length === this.greaters.length) {
			this.median = (this.lowers.peek() + this.greaters.peek())	/ 2;
		} else if(this.lowers.length > this.greaters.length) {
			this.median = this.lowers.peek();
		} else {
			this.median = this.greaters.peek();
		}
	}
	getMedian() {
		return this.median;
	}
}
class Heap {
	constructor(comparisonFunc, array) {
		this.comparisonFunc = comparisonFunc;
		this.heap = this.buildHeap(array);
		this.length = this.heap.length;
	}

	buildHeap(array) {
		const firstParentIdx = Math.floor((array.length - 2) / 2);
		for(let currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
			this.siftDown(currentIdx, array.length - 1, array);
		}
		return array;
	}
	siftDown(currentIdx, endIdx, heap) {
		let childOneIdx = currentIdx * 2 + 1;
		while(childOneIdx <= endIdx) {
			const childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
			let idxToSwap;
			if(childTwoIdx !== -1) {
				if(this.comparisonFunc(heap[childTwoIdx], heap[childOneIdx])) {
					idxToSwap = childTwoIdx;
				} else {
					idxToSwap = childOneIdx;
				}
			} else {
				idxToSwap = childOneIdx;
			} if(this.comparisonFunc(heap[idxToSwap], heap[currentIdx])) {
				this.swap(currentIdx, idxToSwap, heap);
				currentIdx = idxToSwap;
				childOneIdx = currentIdx * 2 + 1;
			} else {
				return;
			}
		}
	}
	siftUp(currentIdx, heap) {
		let parentIdx = Math.floor((currentIdx - 1) / 2);
		while(currentIdx > 0) {
			if(this.comparisonFunc(heap[currentIdx], heap[parentIdx])) {
				this.swap(currentIdx, parentIdx, heap);
				currentIdx = parentIdx;
				parentIdx = Math.floor((currentIdx - 1) / 2);
			} else {
				return;
			}
		}
	}
	
	peek() {
		return this.heap[0];
	}
	
	remove() {
		this.swap(0, this.length - 1, this.heap);
		const valueToRemove = this.heap.pop();
		this.length--;
		this.siftDown(0, this.length - 1, this.heap);
		return valueToRemove;
	}
	
	insert(value) {
		this.heap.push(value);
		this.length++;
		this.siftUp(this.length - 1, this.heap);
	}
	
	swap(i, j, heap) {
		[ heap[i], heap[j] ] = [ heap[j], heap[i] ];
	}
}

function MAX_HEAP_FUNC(a, b) {
	return a > b;
}
function MIN_HEAP_FUNC(a, b) {
	return a < b;
}