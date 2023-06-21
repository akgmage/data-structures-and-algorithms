/*
  	You're given an array of integers where each integer represents a jump of its value in the array. For instance, the integer
	2  represents a jump of two indices forward in the array; the integer -3  represents a jump of three indices backward in the array.
	If a jump spills past the array's bounds, it wraps over to the other side. For instance, a jump of -1  at index 0 brings us to the
	last index in the array. Similarly, a jump of 1  at the last index in the array brings us to index  0

  	Write a function that returns a boolean representing whether the jumps in the array form a single
	cycle. A single cycle occurs if, starting at any index in the array and following the jumps, every
	element in the array is visited exactly once before landing back on the starting index.

	Sample Input: [2, 3, 1, -4, -4, 2]
	Output:  True

	Explanation:

	The HasSingleCycle function takes an integer array as input and returns a boolean value indicating whether the array
	has a single cycle. It initializes two variables: nextElementVisited to keep track of the number of elements visited, and
	currIdx to track the current index in the array.

	The function enters a loop that continues until all elements in the array are visited. It checks if nextElementVisited is
	greater than 0 (indicating that at least one element has been visited) and currIdx is 0. If this condition is true, it means
	the loop has returned to the starting index prematurely, indicating multiple cycles. In such a case, the function returns
	false.

	Inside the loop, nextElementVisited is incremented by 1, and the currIdx is updated using the getNextIdx function, which we
	will examine next.

	The getNextIdx function takes an integer array and the current index as input and returns the index of the next element in
	the cycle.

	It first retrieves the jump value from the current index in the array. The jump value represents the number of steps to take
	from the current element.

	The nextIdx is calculated by adding the jump value to the current index and taking the modulo % operator with the length of
	the array. This ensures that the index stays within the valid range of the array.

	Finally, there is a check to ensure that nextIdx is non-negative. If it is negative, it means the index has wrapped around to
	the beginning of the array. In such a case, the function adds the length of the array to nextIdx to correctly calculate the next index.

	Once the loop in the HasSingleCycle function completes, the final check is made to ensure that the currIdx is back at the
	starting index (0). If it is, it means all elements have been visited in a single cycle, and the function returns true.
	Otherwise, it returns false.

	Overall, this code snippet implements the logic to determine whether an array has a single cycle by tracking the indices
	and jumps between elements.

	Time Complexity : O(n) where n is the length of the input array
	Space Complexity : O(1)
*/
function hasSingleCycle(array) {
  let nextElementVisited = 0;
  let currIdx = 0;

  while (nextElementVisited < array.length) {
    // Check if more than one element has been visited and current index is back to the starting index (0)
    if (nextElementVisited > 0 && currIdx === 0) {
      return false; // Multiple cycles detected, return false
    }

    nextElementVisited += 1; // Increment the count of visited elements
    currIdx = getNextIdx(array, currIdx); // Get the index of the next element
  }

  return currIdx === 0; // Return true if all elements have been visited in a single cycle
}

function getNextIdx(array, currIdx) {
  const jump = array[currIdx]; // Get the jump value from the current index
  const nextIdx = (currIdx + jump) % array.length; // Calculate the index of the next element

  if (nextIdx >= 0) {
    return nextIdx; // Return the next index if it is non-negative
  }

  return nextIdx + array.length; // Adjust the next index if it is negative (wrapped around to the beginning)
}

// Test cases
const array1 = [2, 3, 1, -4, -4, 2];
console.log("Array 1:", hasSingleCycle(array1));

const array2 = [2, 2, -1];
console.log("Array 2:", hasSingleCycle(array2));
