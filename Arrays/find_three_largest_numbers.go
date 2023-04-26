package main
import "math"

func FindThreeLargestNumbers(array []int) []int {
	triplets := []int{math.MinInt32, math.MinInt32, math.MinInt32}
    for _, num := range array {
        updateLargest(triplets, num)
    }
    return triplets
}

func updateLargest(triplets []int, num int) {
    if num > triplets[2] {
        shiftAndUpdate(triplets, num, 2)
    } else if num > triplets[1] {
        shiftAndUpdate(triplets, num, 1)
    } else if num > triplets[0] {
        shiftAndUpdate(triplets, num, 0)
    }
}

func shiftAndUpdate(triplets []int, num int, idx int) {
    for i := 0 ; i < idx + 1; i++ {
        if i == idx {
            triplets[i] = num
        } else {
            triplets[i] = triplets[i + 1]
        }
    }
}