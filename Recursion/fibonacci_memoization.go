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
// array based implementation 0th fib = 1
func Fibonacci(n int) int {	
	if F[n] != -1 {
		return F[n]
	}
	F[n] = Fibonacci(n - 1) + Fibonacci(n - 2)
	return F[n]
}
// more optimized 1st fibonacci = 0, second = 1
func GetNthFib(n int) int {
    firstNo := 0
    secondNo := 1
    result := 0
    if n <= 2 {
        return n - 1
    } 
    for i := 2; i < n; i++ {
		// move first and second to to next iteration
        result = firstNo + secondNo
        firstNo = secondNo
        secondNo = result
    }
	return result
}
func main() {
	for i := 0; i < 51; i++ {
		F[i] = -1
	}
	F[0] = 0
	F[1] = 1
	msg := Fibonacci(5)
	fmt.Println(msg)
	msg = GetNthFib(5)
	fmt.Println(msg)
}