package main

import "fmt"

func Parity(x int) int {
	result := 0
	for x > 0 {
		result ^= (x & 1)
		x >>= 1
		
	}
	return result
}

func main() {
	msg := Parity(4)
	fmt.Println(msg)
}