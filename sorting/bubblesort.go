package main

import "fmt"

func main() {
	arr := [6]int{2, 1, 3, 5, 4, 0}
	// arr := [6]int{0, 1, 2, 3, 4, 5} uncomment for best case
	flag := true
	for i := 0; i < 6; i++ {
		for j := 0; j < 6 - i - 1; j++ {
			if(arr[j] > arr[j + 1]) {
				arr[j], arr[j + 1] = arr[j + 1], arr[j]
				flag = false
			}
		}
		if flag {
			fmt.Println("Already sorted so no further redundant passes best case O(n)")
			break
		}
	} 
	fmt.Println(arr)

}