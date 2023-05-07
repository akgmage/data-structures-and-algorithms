// Roman To Integer
/*
	This implementation converts a given Roman numeral string to its corresponding integer value.
	The implementation uses a map to store the integer value of each Roman numeral, and then
	iterates over the input string, checking if the next Roman numeral is greater than the
	current one to determine whether to add or subtract the current value from the result.
	The time complexity of this implementation is O(n), where n is the length of the input string,
	since it iterates over the string only once. The space complexity is O(1), since the
	implementation only uses a constant amount of extra space to store the map and result variable.

	Time complexity: O(n), where n is the length of the input string. The program iterates through
	each character in the string once and performs a constant number of operations for each character.
	Therefore, the time complexity is linear in the length of the input string.

	Space complexity: O(1). The program uses a constant amount of extra space to store the result
	and the current and previous values. Therefore, the space complexity is constant, or O(1).
*/
package main

import (
	"fmt"
)

func romanToInt(s string) int {
    // Create a map to store the integer value of each Roman numeral
    romanToIntMap := map[byte]int{
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    }
    
    // Initialize the result variable to 0
    result := 0
    
    // Iterate over the input string
    for i := 0; i < len(s); i++ {
        // Get the integer value of the current Roman numeral
        val := romanToIntMap[s[i]]
        
        // Check if the next Roman numeral is greater than the current one
        if i+1 < len(s) && romanToIntMap[s[i+1]] > val {
            // If the next Roman numeral is greater, subtract the current value from the result
            result -= val
        } else {
            // If the next Roman numeral is not greater, add the current value to the result
            result += val
        }
    }
    
    // Return the final result
    return result
}



func main() {
	input := "IV"
    output := romanToInt(input)
    fmt.Printf("Roman numeral %s converted to integer is: %d\n", input, output)

}