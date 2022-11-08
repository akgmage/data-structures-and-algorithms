// Count the number of digits in an integer
package main

import "fmt"

func CountDigits(n int) int {
	if n == 0 {
		return 0;
	}
	smallNo := CountDigits(n / 10)
	return smallNo + 1
}

func main() {
	msg := CountDigits(2003)
	fmt.Println(msg)
}