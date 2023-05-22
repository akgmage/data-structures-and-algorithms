/*
Problem Statement:

You are given a sorted array arr[] containing n integers, where n >= 0.
The array may contain duplicate elements.
Your task is to design an algorithm to find the indices of the
first and last occurrences of a given element x in the array arr[].

Example:
Input: n=10,x=2
arr[]={1,2,2,2,2,3,4,5,7,8}
Here, x=2
So, checking for the first occurrence we find that '2' appears for the first time on index 1.
Similarly, checking for last occurrence we find that '2' appears for the last time on index 4.
Note: the array is '0' indexed.

Output:{1,4}
*/

/*

Approach:
An efficient approach using binary search:
1. For the first occurrence of a number

a) If (high >= low)
b) Calculate  mid = low + (high – low)/2;
c) If ((mid == 0 || x > arr[mid-1]) && arr[mid] == x)
        return mid;
d) Else if (x > arr[mid])
       return first(arr, (mid + 1), high, x, n);
e) Else
       return first(arr, low, (mid -1), x, n);
f) Otherwise return -1;

2. For the last occurrence of a number

a) if (high >= low)
b) calculate mid = low + (high – low)/2;
c)if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
        return mid;
d) else if(x < arr[mid])
       return last(arr, low, (mid -1), x, n);
e) else
      return last(arr, (mid + 1), high, x, n);
f) otherwise return -1;
*/

// Implementation of above approach
package main

import "fmt"

// If x is present in arr[], return the index of the first occurrence of x.
// Otherwise, return -1.
func first(arr []int, low, high, x int) int {
	if high >= low {
		//finding the mid position
		mid := (low + high) / 2

		if (mid == 0 || x > arr[mid-1]) && arr[mid] == x {
			//if element found
			return mid
		} else if arr[mid] < x {
			//if element is smaller than key than search in second half
			return first(arr, mid+1, high, x)
		} else {
			//if element is larger than key search in first half
			return first(arr, low, mid-1, x)
		}
	}
	//return -1 if element not found
	return -1
}

// If x is present in arr[], return the index of the last occurrence of x.
// Otherwise, return -1.
func last(arr []int, low, high, x int) int {
	if high >= low {
		//finding the mid position
		mid := (low + high) / 2

		if (mid == len(arr)-1 || x < arr[mid+1]) && arr[mid] == x {
			//if element found
			return mid
		} else if arr[mid] > x {
			//if element is smaller than key than search in second half
			return last(arr, low, mid-1, x)
		} else {
			//if element is larger than key search in first half
			return last(arr, mid+1, high, x)
		}
	}
	//return -1 if element not found
	return -1
}

func main() {
	// inititalising variables x and n
	//where x is the element to be found
	//n is the array size
	var n, x int

	//taking input n and x
	fmt.Scan(&n)
	fmt.Scan(&x)

	//array initialisation
	arr := make([]int, n)

	//taking array input
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}

	//intialising variables low and high
	low, high := 0, n-1

	//storing answer in variables
	firstOccurrence := first(arr, low, high, x) //firstOccurence to store the first occurence
	lastOccurrence := last(arr, low, high, x)   //lastOccurence to store the last occurence

	//printing the required output
	fmt.Println("First Occurrence:", firstOccurrence)
	fmt.Println("Last Occurrence:", lastOccurrence)
}
