/*
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
*/
package main

import "sort"

// Custom type for representing a single disk's dimensions (width, depth, height)
type Disk []int

// Custom type for representing a collection of disks
type Disks []Disk

// Implementing sort.Interface for Disks to allow sorting based on height (third dimension)
func (disks Disks) Len() int           { return len(disks) }
func (disks Disks) Swap(i, j int)      { disks[i], disks[j] = disks[j], disks[i] }
func (disks Disks) Less(i, j int) bool { return disks[i][2] < disks[j][2] }

// Main function to solve the Disk Stacking problem
func DiskStacking(input [][]int) [][]int {
    // Convert input to Disks slice and sort it based on height in increasing order
    disks := make(Disks, len(input))
    for i, disk := range input {
        disks[i] = disk
    }
    sort.Sort(disks)

    // Initialize slices to store the maximum height and the sequence of disks
    heights := make([]int, len(disks))
    sequences := make([]int, len(disks))
    for i := range disks {
        heights[i] = disks[i][2]
        sequences[i] = -1
    }

    // Dynamic programming loop to find the maximum height and contributing disks
    for i := 1; i < len(disks); i++ {
        currentDisk := disks[i]
        for j := 0; j < i; j++ {
            other := disks[j]

            // Check if conditions are met to stack currentDisk on top of other
            if areValidDimensions(other, currentDisk) {
                // Update maximum height and contributing disk index if needed
                if heights[i] <= currentDisk[2]+heights[j] {
                    heights[i] = currentDisk[2] + heights[j]
                    sequences[i] = j
                }
            }
        }
    }

    // Find the index with the maximum height (topmost disk in the stack)
    maxIndex := 0
    for i, height := range heights {
        if height > heights[maxIndex] {
            maxIndex = i
        }
    }

    // Build the sequence of disks contributing to the maximum height
    sequence := buildSequence(disks, sequences, maxIndex)

    // Return the sequence of disks that should be stacked to achieve the maximum height
    return sequence
}

// Function to check if the conditions are met for placing current disk on top of other
func areValidDimensions(o Disk, c Disk) bool {
    return o[0] < c[0] && o[1] < c[1] && o[2] < c[2]
}

// Function to build the sequence of disks contributing to the maximum height
func buildSequence(disks []Disk, sequences []int, index int) [][]int {
    sequence := [][]int{}
    for index != -1 {
        sequence = append(sequence, disks[index])
        index = sequences[index]
    }
    // Since the sequence is built in reverse order (top to bottom), reverse it to get correct order
    reverse(sequence)
    return sequence
}

// Function to reverse the order of elements in a 2D slice
func reverse(numbers [][]int) {
    for i, j := 0, len(numbers)-1; i < j; i, j = i+1, j-1 {
        numbers[i], numbers[j] = numbers[j], numbers[i]
    }
}
