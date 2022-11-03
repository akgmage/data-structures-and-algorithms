// Program to count the number of bits that are set to 1 in an integer
// The following program tests bits one at a time starting with the least-significant bit.
// Since we perform O(1) computation per bit, the time complexity is O(n) where n is number of bits in the integer
// Best case time complexity is O(1), if the input io 0
package main

import (
	"errors"
	"fmt"
)

func CountBits(x int) (int, error) {
	if x < 0 {
		return x, errors.New("Negative number")
	}
	numBits := 0
	for x > 0{
		numBits += x & 1
		x >>= 1
	}
	return numBits, nil
}

func main() {
	res, err := CountBits(7)
	fmt.Println(res)
	fmt.Println(err)
	
}