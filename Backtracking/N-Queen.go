package main

import (
    "fmt"
)

func solveNQueens(n int) [][]string {
    var result [][]string
    board := make([][]rune, n)
    for i := range board {
        board[i] = make([]rune, n)
        for j := range board[i] {
            board[i][j] = '.'
        }
    }
    
    var isSafe func(row, col int) bool
    isSafe = func(row, col int) bool {
        // Check if no queen attacks this cell horizontally
        for i := 0; i < col; i++ {
            if board[row][i] == 'Q' {
                return false
            }
        }
        
        // Check if no queen attacks this cell diagonally (left upper diagonal)
        for i, j := row, col; i >= 0 && j >= 0; i, j = i-1, j-1 {
            if board[i][j] == 'Q' {
                return false
            }
        }
        
        // Check if no queen attacks this cell diagonally (left lower diagonal)
        for i, j := row, col; i < n && j >= 0; i, j = i+1, j-1 {
            if board[i][j] == 'Q' {
                return false
            }
        }
        
        return true
    }
    
    var backtrack func(col int)
    backtrack = func(col int) {
        if col == n {
            var solution []string
            for _, row := range board {
                solution = append(solution, string(row))
            }
            result = append(result, solution)
            return
        }
        
        for row := 0; row < n; row++ {
            if isSafe(row, col) {
                board[row][col] = 'Q'
                backtrack(col + 1)
                board[row][col] = '.'
            }
        }
    }
    
    backtrack(0)
    return result
}

func main() {
    n := 4 // Change this value to the desired board size
    solutions := solveNQueens(n)
    
    fmt.Printf("Solutions for %d-Queens problem:\n", n)
    for i, solution := range solutions {
        fmt.Printf("Solution %d:\n", i+1)
        for _, row := range solution {
            fmt.Println(row)
        }
        fmt.Println()
    }
}
