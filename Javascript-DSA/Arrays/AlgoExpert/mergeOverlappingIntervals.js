//? https://www.algoexpert.io/questions/Merge%20Overlapping%20Intervals
 //! O(nlogn) time | O(n) space
function mergeOverlappingIntervals(intervals) {
const sortedIntervals = intervals.sort((a, b) => a[0] - b[0]);

	const mergedIntervals = [];
	let currentInterval = sortedIntervals[0];
	mergedIntervals.push(currentInterval);
	
	for(const nextInterval of sortedIntervals) {
 		const [_, currentIntervalEnd] = currentInterval;
		const [nextIntervalStart, nextIntervalEnd] = nextInterval;               
		if(currentIntervalEnd >= nextIntervalStart) {
            currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
        }
		else {
			currentInterval = nextInterval;
			mergedIntervals.push(currentInterval);
		}
	}
		return mergedIntervals;
}

console.log(mergeOverlappingIntervals([[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]));

