/*
  	Write a function that takes in an array of integers and returns the length of the longest peak in the array.
	A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak),
	at which point they become strictly decreasing. At least three integers are required to form a peak.

	The code defines a function named LongestPeak that takes an array of integers as an argument and returns an integer
	representing the length of the longest "peak" in the array.

	A "peak" is defined as a sequence of integers in the array that begins with an increasing sequence of integers,
	reaches a maximum value (the "peak"), and ends with a decreasing sequence of integers.

	The function first initializes a variable longestPeak to 0, which will be used to store the length of the longest
	peak found so far. It then initializes a variable i to 1, which will be used to iterate over the elements of the array.

	The function then enters a loop that continues until i is less than len(array) - 1. Inside the loop, the function checks
	whether the current element at i is a peak, by comparing it to its neighboring elements. If it is not a peak, the loop continues by incrementing i.

	If the current element at i is a peak, the function searches to the left and right of the peak to find the beginning
	and end of the peak. It does this by iterating left and right from the peak until it finds a decreasing sequence of
	integers, using the variables leftIndex and rightIndex.

	Once the function has found the beginning and end of the peak, it calculates the length of the peak using the formula
	rightIndex - leftIndex - 1. If the length of the current peak is greater than the current longest peak, it updates
	longestPeak to the length of the current peak.

	Finally, the function updates the value of i to be the end of the peak (rightIndex), so that the loop will skip over
	the entire peak and continue iterating from the end of the peak.

	The function returns the value of longestPeak once it has finished iterating over the array.

	The time complexity of the LongestPeak function is O(n), where n is the length of the input array, because it iterates through the array only once.

	The space complexity of the function is O(1), because it uses a constant amount of extra space, regardless of the size of the input array.
*/
function longestPeak(array) {
  let longestPeak = 0;
  let i = 1;

  while (i < array.length - 1) {
    // Check if i is a peak (i.e., it's greater than its neighbors)
    const isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

    if (!isPeak) {
      // If i is not a peak, move to the next element
      i += 1;
      continue;
    }

    // Search left of i to find the beginning of the peak
    let leftIndex = i - 2;
    while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
      leftIndex--;
    }

    // Search right of i to find the end of the peak
    let rightIndex = i + 2;
    while (
      rightIndex < array.length &&
      array[rightIndex] < array[rightIndex - 1]
    ) {
      rightIndex++;
    }

    // Calculate the length of the current peak
    const currentPeak = rightIndex - leftIndex - 1;

    // Update longestPeak if currentPeak is longer
    if (currentPeak > longestPeak) {
      longestPeak = currentPeak;
    }

    // Move i to the end of the current peak
    i = rightIndex;
  }

  return longestPeak;
}

// Test the function
const array = [1, 3, 2, 1, 4, 7, 3, 2, 1];
const result = longestPeak(array);
console.log(result); // Output: 6
