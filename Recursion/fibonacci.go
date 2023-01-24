// Fibonacci numbers, commonly denoted Fn , form a sequence, the Fibonacci sequence,
// in which each number is the sum of the two preceding ones.
// The sequence commonly starts from 0 and 1, although some authors start the sequence
// from 1 and 1 or sometimes (as did Fibonacci) from 1 and 2. Starting from 0 and 1,
// the first few values in the sequence are:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144.

// Sample Input: 5
// Output: 5
// Sample Input: 7
// Output: 13
package main

import "fmt"

func Fibonacci(n int) int {
	if n <= 1 {
		return n
	}
	return Fibonacci(n - 1) + Fibonacci(n - 2)
}

func main() {
	msg := Fibonacci(7)
	fmt.Println(msg)
}