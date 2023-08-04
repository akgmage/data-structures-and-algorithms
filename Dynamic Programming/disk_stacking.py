'''
	You're given a non-empty array of arrays where each subarray holds three integers and represents a disk.
	These integers denote each disk's width, depth, and height, respectively. Your goal is to stack up the
	disks and to maximize the total height of the stack. A disk must have a strictly smaller width, depth,
	and height than any other disk below it.

	Write a function that returns an array of the disks in the final stack, starting with the top disk and
	ending with the bottom disk. Note that you can't rotate disks; in other words, the integers in each subarray must
	represent [width, depth, height] at all times

	Sample input :  = [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]
	Output: [[2, 1, 2], [3, 2, 3], [4, 4, 5]] // 10 (2 + 3 + 5) is the tallest height we can get by

	Explanation:
	This code snippet implements the "Disk Stacking" problem, which is a classic dynamic programming problem. The goal is to
	find the maximum height that can be achieved by stacking disks on top of each other while adhering to certain conditions.

	The problem is defined as follows:
	Given a list of disks represented by their dimensions (width, depth, height), you need to find a stack of disks with the
	maximum height. You can only stack a disk on top of another if its width, depth, and height are all strictly smaller than
	those of the disk below it.

	Now, let's go through the code step by step:

	1. `Disk` and `Disks` types: These are custom types defined to simplify the code and make it more readable. `Disk` represents
	a single disk's dimensions, and `Disks` is a slice of `Disk`, representing a collection of disks.

	2. Implementing sort interface for `Disks`: The `Disks` type is provided with three methods - `Len`, `Swap`, and `Less`.
	These methods are part of the `sort.Interface`, which allows us to sort the disks based on their height (the third dimension).

	3. `DiskStacking` function: This is the main function that solves the disk stacking problem. It takes a 2D slice `input`,
	representing the dimensions of the disks, and returns a 2D slice representing the sequence of disks to stack to achieve
	the maximum height.

	4. Creating `disks` slice and sorting: The function first converts the input to a `Disks` slice and then sorts it based on
	the third dimension (height) in increasing order. Sorting will allow us to consider disks in a specific order while building
	the stack.

	5. Initializing `heights` and `sequences` slices: The function initializes two slices, `heights` and `sequences`, both with
	the same length as the number of disks. `heights` will keep track of the maximum height achievable with the current disk at
	each position, and `sequences` will store the index of the previous disk that contributes to the current disk's maximum height.

	6. Dynamic programming loop: The function iterates over each disk and calculates the maximum height that can be achieved by
	considering the current disk and all the disks before it. It checks if the conditions (`areValidDimensions`) for placing the
	current disk on top of another are met, and if so, it updates the maximum height and the contributing disk index in `heights`
	and `sequences`.

	7. Finding the maximum height and the sequence: After the dynamic programming loop, it finds the index with the maximum
	height in the `heights` slice. This index represents the topmost disk in the stack, which contributes to the maximum height.

	8. Building the sequence: The function calls the `buildSequence` function to create the sequence of disks contributing to
	the maximum height. It starts from the topmost disk (found in the previous step) and follows the sequence of disks using the
	`sequences` slice.

	9. Reversing the sequence: The sequence is built in reverse order, starting from the topmost disk. Since the problem requires
	the disks to be stacked from bottom to top, the `reverse` function is used to reverse the order of elements in the sequence.

	10. Returning the result: Finally, the function returns the sequence of disks that should be stacked to achieve the maximum height.

	O(n^2) time | O(n) space - where n is the number of disks
'''
def DiskStacking(disks):
    # Sort the disks based on their height
    disks.sort(key=lambda x: x[2])
    
    # Initialize arrays to store heights and sequences
    heights = [disk[2] for disk in disks]  # Heights of each disk
    sequences = [-1 for _ in disks]  # Index sequence for each disk
    
    # Loop through each disk and calculate the maximum height
    for i in range(1, len(disks)):
        current_disk = disks[i]
        for j in range(i):
            other_disk = disks[j]
            # Check if the dimensions of the other_disk are valid for stacking
            if are_valid_dimensions(other_disk, current_disk):
                # Update the height and sequence if the condition is met
                if heights[i] <= current_disk[2] + heights[j]:
                    heights[i] = current_disk[2] + heights[j]
                    sequences[i] = j
    
    # Find the index of the maximum height
    max_index = heights.index(max(heights))
    
    # Build and return the sequence of disks for the maximum height
    sequence = build_sequence(disks, sequences, max_index)
    return sequence

def are_valid_dimensions(other_disk, current_disk):
    # Check if the dimensions of other_disk allow current_disk to be stacked on top
    return other_disk[0] < current_disk[0] and other_disk[1] < current_disk[1] and other_disk[2] < current_disk[2]

def build_sequence(disks, sequences, index):
    sequence = []
    # Build the sequence of disks for the maximum height
    while index != -1:
        sequence.append(disks[index])
        index = sequences[index]
    sequence.reverse()  # Reverse the sequence to maintain the correct order
    return sequence
