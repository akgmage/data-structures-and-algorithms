/*
                            Radix Sort
1. Identify the maximum number: Find the maximum number in the given list. This is necessary to determine the number of digits we need to consider 
during the sorting process.

2. Perform counting sort for each digit position: Starting from the least significant digit (rightmost digit), perform the following steps for each 
digit position, moving towards the most significant digit (leftmost digit):
a. Create a count array: Create a count array of size 10 (to represent digits 0-9) and initialize all elements to 0. This count array will be used 
to store the frequency of each digit at the current position.
b. Count the frequencies: Iterate through the list of numbers and count the frequency of each digit at the current position. For example, if the 
current digit position is the units place, count the frequency of each digit from 0 to 9.
c. Update the count array: Modify the count array such that each element represents the cumulative count of digits up to that index. This step 
ensures that the count array contains the correct positions for each digit in the sorted order.
d. Distribute the numbers: Iterate through the list of numbers again, and for each number, find its digit at the current position. Use the count 
array to determine the correct position of the number in the output array and place it there. After placing the number, decrement the count for 
that digit in the count array.
e. Collect the numbers: After distributing all the numbers, collect them back into the original array. The array will now be partially sorted 
based on the current digit position.

3. Repeat the counting sort for the next digit position: After collecting the numbers based on the least significant digit, move to the next digit 
position (towards the left) and repeat steps 2a to 2e for that digit. Continue this process until all the digits have been processed, from the least 
significant digit to the most significant digit.

4. Final sorted list: After completing the counting sort process for all digit positions, you will have a fully sorted list of numbers.

Here's an example to illustrate the process:

Sample Input: [170, 45, 75, 90, 802, 24, 2, 66]
Maximum number: 802

# 1. First iteration (Least significant digit - rightmost digit):
    # Create the count array: [0, 2, 1, 1, 0, 1, 0, 0, 0, 1]
    # Update the count array: [0, 2, 3, 4, 4, 5, 5, 5, 5, 6]
    # Distribute the numbers: [802, 2, 24, 45, 75, 170, 90, 66]
    # Collect the numbers: [802, 2, 24, 45, 75, 170, 90, 66]

# 2. Second iteration (Next least significant digit):
    # Create the count array: [1, 2, 1, 1, 1, 1, 0, 0, 0, 1]
    # Update the count array: [1, 3, 4, 5, 6, 7, 7, 7, 7, 8]
    # Distribute the numbers: [802, 2, 24, 45, 66, 75, 90, 170]
    # Collect the numbers: [802, 2, 24, 45, 66, 75, 90, 170]

# 3. Third iteration (Most significant digit):
    # Create the count array: [1, 1, 1, 1, 2, 2, 1, 0, 0, 0]
    # Update the count array: [1, 2, 3, 4, 6, 8, 9, 9, 9, 9]
    # Distribute the numbers: [2, 24, 45, 66, 75, 90, 170, 802]
    # Collect the numbers: [2, 24, 45, 66, 75, 90, 170, 802]

# The final sorted list is [2, 24, 45, 66, 75, 90, 170, 802].

# Radix sort using counting sort works by sorting the numbers digit by digit, from the least significant digit to the most significant digit. 
# The counting sort process distributes and collects the numbers based on each digit position, ensuring that the numbers are correctly ordered at 
# each iteration. By repeating this process for each digit, the algorithm achieves a fully sorted list without the need for explicit element comparisons.

*/

import java.io.*;
import java.util.*;

class Radix {

	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(int arr[], int n, int exp)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current
		// digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	static void radixsort(int arr[], int n)
	{
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	// A utility function to print an array
	static void print(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Main driver method
	public static void main(String[] args)
	{
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;

		// Function Call
		radixsort(arr, n);
		print(arr, n);
	}
}

// Time Compexity -> O((n+k)*d)
// Space Complexity -> O(n+k)