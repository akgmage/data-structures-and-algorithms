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
