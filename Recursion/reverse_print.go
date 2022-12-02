package main

import "fmt"

func print(n int) int {
	if n == 0 {
		return 0
	}
	fmt.Println(n)
	return print(n - 1)
}

func main() {
	print(10)
}