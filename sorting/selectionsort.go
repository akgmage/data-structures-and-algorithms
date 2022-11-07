package main

func SelectionSort(arr []int, length int) []int {
	for i := 0; i < length-1; i++ {
		imin := i
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[imin] {
				imin = j
			}
		}
		arr[i], arr[imin] = arr[imin], arr[i]
	}
	return arr
}

func main() {

}