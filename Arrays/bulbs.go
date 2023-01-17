package main

import "fmt"

func FindMinSwitch(Arr []int) int {
	cost := 0
	for i := 0; i < len(Arr); i++ {
		if cost & 1 != 1 {
		} else {
			Arr[i] = 1 - Arr[i] 
		}
		if Arr[i] & 1 == 1 {
			continue
		} else {
			cost += 1
		}
	}
	return cost
}

func main() {
	Arr := []int{1, 0, 1, 0}
	fmt.Println("-->",FindMinSwitch(Arr))
	Arr = []int{0, 1, 0, 1}
	fmt.Println("-->",FindMinSwitch(Arr))
	Arr = []int{1, 1, 1, 1}
	fmt.Println("-->",FindMinSwitch(Arr))
	Arr = []int{1, 0, 1, 0, 1, 0, 1, 0, 0}
	fmt.Println("-->",FindMinSwitch(Arr))
}