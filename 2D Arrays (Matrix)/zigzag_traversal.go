package main

func ZigzagTraverse(array [][]int) []int {
	height := len(array) - 1
	width := len(array[0]) - 1
	row, col := 0, 0
	goingDown := true
	result := []int{}
	for !isOutOfBounds(row, col, height, width) {
		result = append(result, array[row][col])
		if goingDown {
			if col == 0 || row == height {
				goingDown = false
				if row == height {
					col++
				} else {
					row++
				}
			} else {
				row++
				col--
			}
		} else {
			if row == 0 || col == width {
				goingDown = true
				if col == width {
					row++
				} else {
					col++
				}
			} else {
				row--
				col++
			}
		}
	}
	return result
}

func isOutOfBounds(row, col, height, width int) bool {
	return row < 0 || col < 0 || row > height || col > width
}