// Implementation of Count Numbers with Unique Digits
/*
   This function takes an integer n as input and returns the count of all positive numbers with unique digits that have n
   digits or less. The function first handles the base case where n = 0 (only 1 possible number, 0). For n > 0,
   the function initializes the count to 10 (digits 0-9), and then iterates through each number of digits from 2 to n.
   For each number of digits, the function calculates the number of possible unique numbers and adds it to the total count.
   The number of possible unique numbers for i digits is calculated by first choosing the first digit (9 choices) and then
   choosing each subsequent digit (8 choices for the second digit, 7 choices for the third digit, and so on).
   The product of all these choices is the total number of possible unique numbers for i digits.
   This calculation is repeated for each number of digits from 2 to n, and the total count is returned at the end.

   For example, if n = 2, the function should return 91. There are 10 possible numbers with 1 digit (0-9), and
   91 possible numbers with 2 digits (10-99) that have unique digits
*/
package main

import (
	"fmt"
)

func countNumbersWithUniqueDigits(n int) int {
    // Base case: n = 0, only 1 possible number (0)
    if n == 0 {
        return 1
    }
    
    // For n > 0, initialize count to 10 (digits 0-9)
    count := 10
    
    // Calculate count for 2 to n digits
    for i := 2; i <= n; i++ {
        // For each number of digits, calculate the number of possible unique numbers
        // First digit can be 1-9 (9 choices), subsequent digits can be any of the remaining 9-1 = 8 choices
        // Multiply the choices together to get the total number of possible unique numbers
        // Add this count to the total count
        currCount := 9
        for j := 1; j < i; j++ {
            currCount *= 10 - j
        }
        count += currCount
    }
    
    return count
}

func main() {
    // Test case with n = 2
    fmt.Println(countNumbersWithUniqueDigits(2)) // Output: 91
}
