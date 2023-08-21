//To perform a binary search in a rotated sorted array in Go, you can follow these steps:

//Find the pivot point where the array is rotated.
//Once you have the pivot point, split the array into two subarrays, and perform binary search in one of the subarrays based on the target value.
//If the target value is not found in the first subarray, search in the second subarray.

package main

import "fmt"

func search(nums []int, target int) int {
    left, right := 0, len(nums)-1
    
    for left <= right {
        mid := left + (right-left)/2
        
        if nums[mid] == target {
            return mid
        }
        
        // Check if the left subarray is sorted
        if nums[left] <= nums[mid] {
            // Check if the target is within the left subarray
            if nums[left] <= target && target < nums[mid] {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else { // Right subarray is sorted
            // Check if the target is within the right subarray
            if nums[mid] < target && target <= nums[right] {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    
    return -1 // Target not found
}

func main() {
    nums := []int{4, 5, 6, 7, 0, 1, 2}
    target := 0
    result := search(nums, target)
    
    if result != -1 {
        fmt.Printf("Target %d found at index %d\n", target, result)
    } else {
        fmt.Printf("Target %d not found in the array\n", target)
    }
}
