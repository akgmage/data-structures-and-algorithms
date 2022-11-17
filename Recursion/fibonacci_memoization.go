/*
	Implelement memoized fibonacci

	Memoization is an enhancement procedure used to speed up computer programs by keeping the values
	of distinct function calls and returning the stored input when the same function is invoked again.

	Sample Input: 6
	Output: 8
*/
package main

import "fmt"

var F = make([]int, 51)

func Fibonacci(n int) int {	
	if F[n] != -1 {
		return F[n]
	}
	F[n] = Fibonacci(n - 1) + Fibonacci(n - 2)
	return F[n]
}
func main() {
	for i := 0; i < 51; i++ {
		F[i] = -1
	}
	F[0] = 0
	F[1] = 1
	msg := Fibonacci(7)
	fmt.Println(msg)
}