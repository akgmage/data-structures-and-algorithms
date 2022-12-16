package main

func MergeSort(Arr []int) []int {
	if len(Arr) <= 1 {
		return Arr
	}
	middle := len(Arr) / 2
	left := MergeSort(A[:middle])
	right := MergeSort(A[middle:])
	return Merge(left, right)
}