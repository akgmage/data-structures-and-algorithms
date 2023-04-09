package main

import "fmt"

func rotateClockwise(image [][]int) [][]int {
    n := len(image)
    rotated := make([][]int, n)
    for i := 0; i < n; i++ {
        rotated[i] = make([]int, n)
        for j := 0; j < n; j++ {
            rotated[i][j] = image[n-j-1][i]
        }
    }
    return rotated
}

func rotateCounterClockwise(image [][]int) [][]int {
    n := len(image)
    rotated := make([][]int, n)
    for i := 0; i < n; i++ {
        rotated[i] = make([]int, n)
        for j := 0; j < n; j++ {
            rotated[i][j] = image[j][n-i-1]
        }
    }
    return rotated
}

func main() {
    // example image
    image := [][]int{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
    }

    // rotate clockwise
    rotatedClockwise := rotateClockwise(image)
    fmt.Println("Rotated Clockwise:")
    for _, row := range rotatedClockwise {
        fmt.Println(row)
    }

    // rotate counterclockwise
    rotatedCounterClockwise := rotateCounterClockwise(image)
    fmt.Println("Rotated Counterclockwise:")
    for _, row := range rotatedCounterClockwise {
        fmt.Println(row)
    }
}
