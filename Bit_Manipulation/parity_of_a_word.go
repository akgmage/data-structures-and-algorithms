// Computing the parity of a word
// The parity of a binary word is 1 if the number of 1s in the word is odd
// The parity of a binary word is 0 if the number of 1s in the word is even

// Input : 11
// Output : 1

// Input : 12
// Output : 0

package main

import "fmt"

func Parity(x int) int {
	result := 0
	for x > 0 {
		result ^= (x & 1)
		x >>= 1
		
	}
	return result
}

func main() {
	msg := Parity(11)
	fmt.Println(msg)
	msg = Parity(12)
	fmt.Println(msg)
}