package main

import (
	"fmt"
)

func InsertionSort(A []int) {
	for i := 0; i < len(A); i++ {
		temp := A[i]
		j := i - 1
		for ; j >= 0 && A[j] > temp; j-- {
			A[j+1] = A[j]
		}
		A[j+1] = temp
	}
}

func BucketSort(A []int, bucketSize int) []int {
	var max, min int
	for _, n := range A {
		if n < min {
			min = n
		}
		if n > max {
			max = n
		}
	}
	nBuckets := int(max-min)/bucketSize + 1
	buckets := make([][]int, nBuckets)
	for i := 0; i < nBuckets; i++ {
		buckets[i] = make([]int, 0)
	}

	for _, n := range A {
		idx := int(n-min) / bucketSize
		buckets[idx] = append(buckets[idx], n)
	}

	sorted := make([]int, 0)
	for _, bucket := range buckets {
		if len(bucket) > 0 {
			InsertionSort(bucket)
			sorted = append(sorted, bucket...)
		}
	}

	return sorted
}

func main() {
	A := []int{3, 4, 5, 2, 1}
	A = BucketSort(A, 2)
	for _, val := range A {
		fmt.Println(val)
	}
}