// Computing the parity of a word
// The parity of a binary word is 1 if the number of 1s in the word is odd
// The parity of a binary word is 0 if the number of 1s in the word is even

// Input : 11
// Output : 1

// Input : 12
// Output : 0

package main

import "fmt"

// This algorithm iteratively tests the value of each bit while
// tacking the number of 1's seen so far (Brute Force)
func Parity(x int) int {
	result := 0
	for x > 0 {
		result ^= (x & 1)
		x >>= 1
	}
	return result
}

func ParityImproved(x int) int {
	result := 0
	for x > 0 {
		result ^= 1
		// This can be used to improve the performance in the best and average cases.
		x &= (x - 1) // erase lowest set bit in a word in a single operation
	}
	return result
}

func main() {
	fmt.Println("*********Brute Force*********")
	msg := Parity(11)
	fmt.Println(msg)
	msg = Parity(12)
	fmt.Println(msg)
	fmt.Println("*********Improved*********")
	msg = ParityImproved(11)
	fmt.Println(msg)
	msg = ParityImproved(12)
	fmt.Println(msg)
}
// The time complexity is O(n) where n is word size