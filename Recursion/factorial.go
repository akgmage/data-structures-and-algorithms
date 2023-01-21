// Factorial of an integer
// Sample Input: 5
// Output: 120

package main

import "fmt"

func Factorial(n int) int {
	if n == 0 {
		return 1;
	}
	return n * Factorial(n - 1)
}

func main() {
	msg := Factorial(5);
	fmt.Println(msg)
}