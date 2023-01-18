/*
	N light bulbs are connected by a wire.
	Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
	Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
	You can press the same switch multiple times.
	Note : 0 represents the bulb is off and 1 represents the bulb is on.
*/
ackage main

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