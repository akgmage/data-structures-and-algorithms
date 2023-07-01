/*
	Move Element to end
	Sample Input : [1, 0, 3, 0, 0, 5] To move: 0
	Output : [1, 3, 5, 0, 0, 0]

	This is a function called MoveElementToEnd that takes an array of integers array and an integer toMove as input,
	and returns a modified array with all instances of toMove moved to the end of the array.

	The function first initializes an integer variable index to 0, which will keep track of the index of the first
	element in the array that is not equal to toMove. Then, it loops through the array using a for loop, and if the
	current element is not equal to toMove, it replaces the element at the index position with the current element
	and increments the index variable by 1. This effectively shifts all elements that are not equal to toMove to the
	beginning of the array.

	Next, the function loops through the remaining elements of the array (i.e., those that were not overwritten in
	the previous loop), and sets their value to toMove. This effectively moves all instances of toMove to the
	end of the array.

	Finally, the modified array is returned.

	O(n) time | O(1) space - where n is the length of the array
*/
#include <vector>

std::vector<int> MoveElementToEnd(std::vector<int>& array, int toMove) {
    int index = 0; // initialize a variable to keep track of the index where elements should be moved to
    for (int i = 0; i < array.size(); i++) { // loop through the entire array
        if (array[i] != toMove) { // check if the current element is not equal to the element to be moved
            array[index] = array[i]; // move the current element to the left side of the array by replacing the element at the current index (index) with the current element (array[i])
            index++; // increment the index variable by 1 to keep track of the index where the next non-target element should be moved
        }
    }
    for (int i = index; i < array.size(); i++) { // loop through the remaining elements in the array from index to the end
        array[i] = toMove; // set each element to be the target element
    }
    return array; // return the modified array
}
