'''
	Given an array of integers A, find and return the product array of the same size where the ith
	element of the product array will be equal to the product of all the elements divided by the ith
	element of the array.

	Note: It is always possible to form the product array with integer (32 bit) values.
	Solve it without using the division operator.

	Input: [1, 2, 3, 4, 5]
	Output : [120, 60, 40, 30, 24]

	Explanation:
	The code snippet provides a function called `ArrayOfProducts` that takes an array of integers as input and returns another array where each element is the product of all the integers in the input array except for the one at that index. Here's how the code works:

	1. It initializes an empty result array with the same length as the input array to store the final products.
	2. It uses a left-to-right approach to compute the running product of all elements to the left of each index.
	3. It initializes a variable `leftRunningProduct` to keep track of the running product of elements on the left side.
	4. It iterates over the input array from left to right using a `for` loop.
	5. For each index `i`, it stores the current `leftRunningProduct` in the result array at index `i` and then updates the
	   `leftRunningProduct` by multiplying it with the corresponding element in the input array.
	6. After the loop, the result array will contain the product of all elements to the left of each index.
	7. It uses a right-to-left approach to compute the running product of all elements to the right of each index and
	   multiply it with the corresponding left product in the result array.
	8. It initializes a variable `rightRunningProduct` to keep track of the running product of elements on the right side.
	9. It iterates over the input array from right to left using a `for` loop.
	10. For each index `i`, it multiplies the `rightRunningProduct` with the corresponding left product in the result array
	   and updates the `rightRunningProduct` by multiplying it with the corresponding element in the input array.
	11. After the loop, the result array will contain the product of all elements to the left and right of each index,
	   except for the element at that index.
	12. Finally, it returns the result array.

	This algorithm avoids using division and solves the problem in linear time complexity, making two passes over the input array. The space complexity is also linear, as it uses an additional array to store the products.
'''
def array_of_products(array):
    n = len(array)
    result = [1] * n

    # Compute the running product of all elements to the left of each index
    # and store it in the result array.
    left_running_product = 1
    for i in range(n):
        result[i] = left_running_product  # Store left product in the result array
        left_running_product *= array[i]  # Update left product

    # Compute the running product of all elements to the right of each index
    # and multiply it with the corresponding left product in the result array.
    right_running_product = 1
    for i in range(n - 1, -1, -1):
        result[i] *= right_running_product  # Multiply the right product with the corresponding left product
        right_running_product *= array[i]   # Update right product

    return result

# Example usage
input_array = [1, 2, 3, 4, 5]
output_array = array_of_products(input_array)

# Print the result
print(output_array)
