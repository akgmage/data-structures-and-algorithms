package main
import (
    "math"
    "sort"
)
func SmallestDifference(array1, array2 []int) []int {
	current, smallest := math.MaxInt32, math.MaxInt32
    sort.Ints(array1)
    sort.Ints(array2)
    idx1, idx2 := 0, 0
    result := []int{}
    for idx1 < len(array1) && idx2 < len(array2) {
        first, second := array1[idx1], array2[idx2]
        if first < second {
            current = second - first
            idx1++
        } else if second < first {
            current = first - second
            idx2++
        } else {
            return []int{first, second}
        }
        if smallest > current {
            smallest = current
            result = []int{first, second}
        }
    }
    return result
}