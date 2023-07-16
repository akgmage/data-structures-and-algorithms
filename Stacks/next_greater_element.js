/*

  	Write a function that takes in an array of integers and returns a new array containing, at each index, the next
	element in the input array that's greater than the element at that index in the input array.

	Sample Input:[2, 5, -3, -4, 6, 7, 2]
	Output: [5, 6, 6, 6, 7, -1, 5]
	Explanation:

	The given code snippet implements the Next Greater Element algorithm. Here's how it works:

	1. The function `NextGreaterElement` takes an input array of integers and returns an array of the same length
	   where each element represents the next greater element in the input array. If there is no greater element, the corresponding output element is set to -1.

	2. The `result` slice is initialized with -1 values, indicating that there are no greater elements initially.

	3. The `stack` is used to keep track of indices of elements from the input array. It will store indices in a
	   way that maintains a decreasing order of values from the input array.

	4. The algorithm performs two passes over the input array. In each pass, it considers the array elements in a
	   circular manner by using the modulo operator `%` on the index.

	5. In the inner loop, the algorithm checks if the current element is greater than the element at the top of the stack.
	   If it is, it means the current element is the next greater element for the element at the top of the stack.

	6. If a greater element is found, the top index is retrieved from the stack, and the corresponding element in the
	   `result` slice is updated with the current element from the input array.

	7. After updating the `result` slice, the top index is removed from the stack.

	8. The current circular index is then pushed onto the stack to potentially find the next greater element for it in
	   the future.

	9. Once the algorithm completes the two passes over the input array, the `result` slice contains the next greater
	   elements for each element in the input array, or -1 if there is no greater element.

	10. The `result` slice is returned as the output.

	The algorithm utilizes a stack to efficiently find the next greater element for each element in the input array.
	By iterating over the array twice in a circular manner, it ensures that all elements have been considered for finding the next greater elements.


	The time complexity of the `NextGreaterElement` function is O(n), where n is the length of the input array.
	This is because the function performs two passes over the input array, and in each pass, it processes each element once. The operations performed within each iteration, such as stack operations, have constant time complexity.

    The space complexity of the function is O(n) as well. This is because the function creates two additional
	slices: `result` and `stack`, each with a maximum size of n. Therefore, the space required by the function grows linearly with the size of the input array.
*/
function nextGreaterElement(array) {
  const result = new Array(array.length).fill(-1); // Initialize result array with -1 for all elements
  const stack = []; // Stack to store indices of elements

  for (let idx = 0; idx < array.length * 2; idx++) {
    const circularIdx = idx % array.length; // Obtain the circular index of the current element

    while (
      stack.length &&
      array[circularIdx] > array[stack[stack.length - 1]]
    ) {
      // While the stack is not empty and the current element is greater than the element at the top of the stack
      const top = stack.pop(); // Pop the index from the stack
      result[top] = array[circularIdx]; // Update the result for the popped index
    }

    stack.push(circularIdx); // Push the current index to the stack
  }

  return result;
}
