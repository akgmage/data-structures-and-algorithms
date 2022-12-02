package main

import "fmt"



func main() {
	A := []int{10, 20, 23, 23, 45, 78, 88}
	fmt.Println(isSorted(A))
	A = []int{10, 20, 23, 7, 23, 45, 78, 88}
	fmt.Println(isSorted(A))
}