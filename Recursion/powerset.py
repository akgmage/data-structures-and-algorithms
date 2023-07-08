'''

	Write a function that takes in an array of unique integers and returns its powerset.

	Sample Input : [1, 2, 3]
	Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]

	Explanation:

	The code snippet represents a function `Powerset` that takes an array of integers as input and returns the powerset
	of the array. The powerset of a set is the set of all possible subsets of that set, including the empty set and the set itself.

	The function `Powerset` calls a helper function `powerset` to perform the actual computation. Here's how the code works:

	1. The `Powerset` function initializes the computation by calling the `powerset` function with the array and the index
	   of the last element in the array (`len(array) - 1`).

	2. The `powerset` function is a recursive function that calculates the powerset. It takes the array and the current
	   index as input.

	3. At each recursive call, the function checks if the index is less than 0. If so, it means all elements have been
	   processed, and it returns a 2D slice containing the empty set as the only subset.

	4. If the index is not less than 0, the function retrieves the element at the current index from the array.

	5. The function recursively calls itself with the array and the index decremented by 1 to generate the subsets without
	   the current element.

	6. It then calculates the length of the subsets generated so far.

	7. Using a loop, the function iterates over the existing subsets and creates new subsets by appending the current element
	   to each subset. The new subsets are added to the existing subset slice.

	8. Finally, the function returns the updated subset slice, which contains all the subsets of the original array.

	By recursively generating subsets while building upon the subsets generated at each step, the function constructs the
	powerset of the given array.

	O(n*2^n) time | O(n*2^n) space - where n is the length of the input array
'''
def powerset(array):
    # Base case: when the index reaches -1, return a list with an empty subset
    if index < 0:
        return [[]]

    element = array[index]
    # Recursive call to generate the powerset for the elements up to index - 1
    subset = powerset(array, index - 1)

    # Length of the current subset list
    length = len(subset)

    # Iterate through each subset and create new subsets by adding the current element
    for i in range(length):
        currentSubset = subset[i]
        # Create a new subset by making a copy of the current subset
        newSubset = currentSubset[:]
        # Add the current element to the new subset
        newSubset.append(element)
        # Add the new subset to the existing subset list
        subset.append(newSubset)

    # Return the resulting subset list
    return subset

def Powerset(array):
    # Call the helper function to generate the powerset starting from the last index
    return powerset(array, len(array) - 1)


# Iterative approach
def powersetIterative(array):
  # Initialize the powerset with the empty subset
  subset = [[]]

  # Iterate over each element in the input array
  for ele in array:
    # Get the current length of the subset
    length = len(subset)

    # Iterate over each existing subset
    for i in range(length):
      # Get the current subset
      currentSubset = subset[i]

      # Create a new subset by making a copy of the current subset
      newSubset = list(currentSubset)

      # Add the current element to the new subset
      newSubset.append(ele)

      # Append the new subset to the powerset
      subset.append(newSubset)

  # Return the powerset
  return subset
