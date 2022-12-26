package main

import "fmt"

func IsSubArrayWithZeroSum(Arr []int) bool {
	prefixSum := make(map[int]bool)
	sum := 0
	for i := 0; i < len(Arr); i++ {
		sum += Arr[i]
		if sum == 0 || prefixSum[sum] == true {
			return true
		}
		prefixSum[sum] = true
	}
	return false
}

func main() {
	Arr := []int{1, 2, 3, 4, -7, 1}
	fmt.Println(IsSubArrayWithZeroSum(Arr))
	Arr = []int{1, 2, 3, 4, 5, 6, 7}
	fmt.Println(IsSubArrayWithZeroSum(Arr))
}