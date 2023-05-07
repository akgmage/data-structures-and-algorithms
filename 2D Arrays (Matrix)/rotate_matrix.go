// Rotate clockwise and anti-clockwise
/*
	The rotateClockwise function takes an image array as input and returns the image rotated by 90 degrees clockwise. 
	It creates a new rotated array with the same dimensions as the original image, and then iterates over 
	each element of the image, assigning it to a new position in the rotated array.

	The rotateCounterClockwise function works similarly, but it rotates the image counterclockwise instead. 
	The n-j-1 and n-i-1 indices are used to swap the rows and columns, respectively.

	In the main function, we create an example image, and then call the rotateClockwise and 
	rotateCounterClockwise functions to rotate the image by 90 degrees in each direction. 
	Finally, we print the rotated images.
*/
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
