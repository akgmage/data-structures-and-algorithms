/*
   This code implements the "Search in Rotated Sorted Array" problem, which requires finding the target value
   in a rotated sorted array.

   The binarySearch function takes a sorted rotated array and the target value as input. It initializes two pointers,
   left and right, to the start and end indices of the array, respectively. It then enters a while loop as long as
   the left pointer is less than or equal to the right pointer.

   Inside the loop, the function calculates the middle index and checks if the middle element is equal to the target.
   If it is, the function returns the middle index.

   Otherwise, it checks if the left half of the array is sorted by comparing the values at the left and middle indices.
   If it is sorted and the target lies within the left half, the right pointer is updated to search only in the left half.
   Otherwise, the left pointer is updated to search in the right half.

   If the left half is not sorted, then the right half must be sorted. In this case, the function checks if the target
   lies within the right half. If it does, the left pointer is updated to search in the right half; otherwise, the right
   pointer is updated to search in the left half.

   If the target is not found in the loop, the function returns -1 to indicate that the target is not present in the array.

   O(log n) time | O(1) space - where n is the length of the input array
*/

package main

func search(nums []int, target int) int {
	left, right := 0, len(nums)-1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			return mid
		}

		if nums[left] <= nums[mid] { // Left half is sorted
			if target >= nums[left] && target < nums[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else { // Right half is sorted
			if target > nums[mid] && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}
