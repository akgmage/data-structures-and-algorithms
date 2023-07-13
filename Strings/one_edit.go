/*
    You're given two strings stringone and stringtwo. Write a function that determines if these 
	two strings can be made equal using only one edit.

	
    There are 3 possible edits:
    Replace: One character in one string is swapped for a different character.
    Add:: One character is added at any index in one string.
    Remove: One character is removed at any index in one string.
        
  
*/
func OneEdit(stringOne string, stringTwo string) bool {
    lengthOne := len(stringOne)
    lengthTwo := len(stringTwo)

    // Check the difference in lengths between the two strings.
    // If the difference is greater than 1, it is not possible to make one edit to make them equal.
    if abs(lengthOne - lengthTwo) > 1 {
        return false
    }

    // Traverse the strings until the shorter one is fully traversed or an unequal character is found.
    for i := 0; i < min(lengthOne, lengthTwo); i++ {
        // If an unequal character is found, check the remaining portion of the strings to determine if they are still one edit away.
        if stringOne[i] != stringTwo[i] {
            // Check the remaining characters in the longer string compared to the remaining characters in the shorter string.
            // Return true if they match, indicating they are one edit away.
            if lengthOne > lengthTwo {
                return stringOne[i+1:] == stringTwo[i:]
            } else if lengthTwo > lengthOne {
                return stringTwo[i+1:] == stringOne[i:]
            } else {
                return stringOne[i+1:] == stringTwo[i+1:]
            }
        }
    }

    // If the loop completes without finding any unequal characters, the strings are either identical or differ only in length by 1.
    return true
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
