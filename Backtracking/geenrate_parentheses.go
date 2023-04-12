// Implementation of generating all combinations of well-formed parentheses
/*
	The generateParenthesis function takes an integer n as input, which represents the number of pairs of 
	parentheses to generate. It initializes an empty array result to store the valid combinations and calls 
	the backtrack helper function to generate all the combinations.

	The backtrack function takes four arguments:

		a pointer to the result array to add the valid combinations
		the current string cur
		the number of open brackets open
		the number of closed brackets close
		the maximum number of pairs of parentheses max

	The function first checks if the current string has reached the maximum length, i.e., len(cur) == max*2. 
	If it has, the function appends the current string to the result array and returns.

	If there are still open brackets left to add, i.e., open < max, the function appends an open bracket to 
	the current string and recursively calls backtrack with open+1 and close. This represents adding an open 
	bracket to the current combination.

	If there are more closed brackets than open brackets, i.e., close < open, the function appends a 
	closed bracket to the current string and recursively calls backtrack with open and close+1. 
	This represents adding a closed bracket to the current combination.

	In the main function, we call generateParenthesis with n=3 and print the resulting array. 
	This will output all possible combinations of three pairs of well-formed parentheses.

	Input: n = 3

	Output: ["((()))","(()())","(())()","()(())","()()()"]

	Explanation:

	There are 5 valid combinations of well-formed parentheses with 3 pairs of parentheses. 
	The output lists all of them.

	The time complexity of the above program is O(4^n / sqrt(n)), where n is the number of parentheses. 
	This is because there are a total of 2n positions in the output string, and at each position,
	we have two choices - either to put an opening or closing parenthesis. Therefore, the total 
	number of possible combinations is 2^(2n). However, not all of these combinations are valid, 
	as some may violate the well-formedness condition. We can use Catalan number to determine the 
	actual number of valid combinations. The nth Catalan number is given by (2n)! / (n+1)!n!, which 
	is approximately equal to 4^n / sqrt(n*pi). Thus, the time complexity is O(4^n / sqrt(n)).
*/
package main

import "fmt"

func generateParenthesis(n int) []string {
    var result []string
    backtrack(&result, "", 0, 0, n)
    return result
}

// helper function to backtrack and generate all valid combinations
func backtrack(result *[]string, cur string, open int, close int, max int) {
    // base case: if the current string has reached the maximum length, add it to the result
    if len(cur) == max*2 {
        *result = append(*result, cur)
        return
    }

    // if there are still open brackets left to add, add one and recurse
    if open < max {
        backtrack(result, cur+"(", open+1, close, max)
    }

    // if there are more closed brackets than open brackets, add a closed bracket and recurse
    if close < open {
        backtrack(result, cur+")", open, close+1, max)
    }
}

func main() {
    result := generateParenthesis(3)
    fmt.Println(result)
}
