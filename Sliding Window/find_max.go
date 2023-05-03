package main
import "fmt"

func printKMax(arr []int, N int, K int) {
    
	var j, max int

	for i := 0; i <= N-K; i++ {
		max = arr[i]

		for j = 1; j < K; j++ {
			if arr[i+j] > max {
				max = arr[i+j]
			}
		}
		fmt.Printf("%d ", max)
	}
}

func main() {

	var N, K int
	fmt.Scan(&N)
	
	arr := make([]int, N)
	for i := 0; i < N; i++ {
	    fmt.Scan(&arr[i])
	}
	
	fmt.Scan(&K)
	
	printKMax(arr, N, K)
}
