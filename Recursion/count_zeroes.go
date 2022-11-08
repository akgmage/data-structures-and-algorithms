// Count the number of 0's in an integer
// Sample Input : 10010
// Output: 3
package main

import "fmt"

func CountZeroes(n int) int {
	if n == 0 {
		return 0;
	}
	// divide the number recursively and hit the base case
	smallNo := CountZeroes(n / 10)
	lastDigit := n % 10
	if lastDigit == 0 {
		smallNo += 1
	} else {
		return smallNo
	}
	return smallNo
}

func main() {
	msg := CountZeroes(1000100100100)
	fmt.Println(msg)
}