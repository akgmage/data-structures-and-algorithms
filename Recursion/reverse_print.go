package main

import "fmt"

// Starting from n print number till 1
func print(n int) int {
	if n == 0 { // base case
		return 0
	}
	fmt.Println(n)
	return print(n - 1)
}

func main() {
	print(10)
}