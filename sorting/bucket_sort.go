/*
	Bucket sort, or bin sort, is a sorting algorithm that works by distributing
	the elements of an array into a number of buckets. Each bucket is then
	sorted individually, either using a different sorting algorithm,
	or by recursively applying the bucket sorting algorithm.
	It is a distribution sort, a generalization of pigeonhole sort that
	allows multiple keys per bucket, and is a cousin of
	radix sort in the most-to-least significant digit flavor.
	Bucket sort can be implemented with comparisons and therefore can also
	be considered a comparison sort algorithm.
	The computational complexity depends on the algorithm used to sort
	each bucket, the number of buckets to use,
	and whether the input is uniformly distributed.

	Bucket sort works as follows:

	Set up an array of initially empty "buckets".
	Scatter: Go over the original array, putting each object in its bucket.
	Sort each non-empty bucket.
	Gather: Visit the buckets in order and put all elements back into the original array.

	Source(https://en.wikipedia.org/wiki/Bucket_sort)
*/
// The average time complexity for Bucket Sort is O(n + k).
// The worst time complexity is O(n²).
// The space complexity for Bucket Sort is O(n+k).
package main

import (
	"fmt"
)

func InsertionSort(Array []int) {
	for i := 0; i < len(Array); i++ {
		temp := Array[i]
		j := i - 1
		for ; j >= 0 && Array[j] > temp; j-- {
			Array[j+1] = Array[j]
		}
		Array[j+1] = temp
	}
}

func BucketSort(Array []int, bucketSize int) []int {
	var max, min int
	for _, n := range Array {
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

	for _, n := range Array {
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
	Array := []int{3, 4, 5, 2, 1}
	Array = BucketSort(Array, 2)
	for _, val := range Array {
		fmt.Println(val)
	}
}