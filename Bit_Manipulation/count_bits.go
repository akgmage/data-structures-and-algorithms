// Program to count the number of bits that are set to 1 in an integer

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