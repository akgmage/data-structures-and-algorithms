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