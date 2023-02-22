/*
Write an algorithm to determine if a number num is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1

Those numbers for which this process ends in 1 are happy.
Return TRUE if num is a happy number, and FALSE if not.

Sample Input : 4
Output: False

Sample Input : 19
Output: True

*/

package main

import "fmt"

// pow calculates the power of the given digit
func pow(digit int, power int) int {
	res := 1
	for i := 0; i < power; i++ {
		res = res * digit
	}
	return res
}

// sumDigits is a helper function that calculates the sum of digits.
func sumDigits(number int) int {
    totalSum := 0
    for number > 0 {
        digit := number % 10
        number = number / 10
        totalSum += pow(digit, 2)
    }
    return totalSum
}

func happyNumber(num int) bool {
	slow := num
	fast := sumDigits(num)
	for fast != 1 && fast != slow {
			slow = sumDigits(slow)
			fast = sumDigits(sumDigits(fast))
	}
	return fast == 1
}

func main() {
	fmt.Println(happyNumber(4)) // false
	fmt.Println(happyNumber(19))  // true
	fmt.Println(happyNumber(100))  // true
}