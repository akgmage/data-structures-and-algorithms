// Integer to Roman
/*
	In this implementation, we create two arrays symbols and values that hold the Roman numeral symbols and their 
	corresponding integer values respectively. We then create a string builder to hold our result.

	We loop through the values array, and while the current num is greater than or equal to the current values 
	element, we subtract the values element from num and append the corresponding symbols element to the result 
	string builder. We continue this process until we have gone through all the values elements.

	Finally, we return the result string.
*/
package main

import "strings"

func intToRoman(num int) string {
	// Create two arrays to hold the Roman numeral symbols and their corresponding values
	symbols := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
	values := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}

	var result strings.Builder
	// Loop through the values array and subtract the corresponding value from num while appending the symbol to the result
	for i := 0; i < len(values); i++ {
		for num >= values[i] {
			num -= values[i]
			result.WriteString(symbols[i])
		}
	}

	return result.String()
}

func main() {
	print(intToRoman(8000))
}