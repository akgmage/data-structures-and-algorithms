func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0 || len(matrix[0]) == 0 {
        return false
    }

    rows, cols := len(matrix), len(matrix[0])
    left, right := 0, rows*cols-1

    for left <= right {
        mid := left + (right-left)/2
        // Convert the 1D index back to 2D coordinates
        row, col := mid/cols, mid%cols
        midValue := matrix[row][col]

        if midValue == target {
            return true
        } else if midValue < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return false
}
